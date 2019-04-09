package kz.aibek.example.Api;

import kz.aibek.example.Config;
import kz.aibek.example.Model.JsonModel;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class JsonApi {
    public static String getText(JsonModel model) throws IOException {
        URL url = new URL(Config.URL);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        model.setText(object.getString("text"));

        return model.getText();

    }
}
