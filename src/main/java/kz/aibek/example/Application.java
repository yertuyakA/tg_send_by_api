package kz.aibek.example;

import kz.aibek.example.Model.JsonModel;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Application {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new SenderBot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
