package main.bot;

import main.enums.BotMenu;
import main.util.BotSettings;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return BotSettings.USER_NAME_BOT;
    }

    @Override
    public String getBotToken() {
        return BotSettings.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        Message message = update.getMessage();
        SendMessage sendMessage = null;
        if(message.hasText()){
            String text = message.getText();
            switch (text){
                case BotMenu.START:
                    sendMessage = BotService.start(update);
                    break;
            }

        }
    }
}
