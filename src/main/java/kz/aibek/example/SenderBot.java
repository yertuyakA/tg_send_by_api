package kz.aibek.example;

import kz.aibek.example.Api.JsonApi;
import kz.aibek.example.Model.JsonModel;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

public class SenderBot extends TelegramLongPollingBot {
    private String lastMessage = " ";

    public void onUpdateReceived(Update update) {
        JsonModel jsonRestModel = new JsonModel();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
                    try {
                        while (true) {
                            try {
                                if (updateChange()) {
                                    sendMsg(message, JsonApi.getText(jsonRestModel));
                                } else {
                                    //do nothing
                                }
                            } catch (IOException s) {
                                System.out.println(")))))");
                            }
                            Thread.sleep(5000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
    }


    public String getBotUsername() {
        return "Ersn";
    }

    public String getBotToken() {
        return Config.TOKEN;
    }

    public void sendMsg(Message message, String text) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);

            sendMessage.setChatId(message.getChatId().toString());

            sendMessage.setText(text);
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


        private boolean updateChange() throws IOException {
            JsonModel jsonRestModel = new JsonModel();

            if (JsonApi.getText(jsonRestModel).equals(lastMessage)) {
                lastMessage = JsonApi.getText(jsonRestModel);
                return false;
            } else {
                lastMessage = JsonApi.getText(jsonRestModel);
                return true;
            }
        }
}
