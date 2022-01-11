package main.bot;

import main.enums.BotMenu;
import main.enums.BotState;
import main.util.BotConstants;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BotService {
    private static UserService userService = new UserServiceImpl();
    private static UserRepository userRepository = new UserRepositoryImpl();
    public static SendMessage start(Update update){
        registerUser(update);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(BotConstants.MENU_HEADER);
        sendMessage.setReplyMarkup(getMenuKeyboard());

        return sendMessage;
    }

    private static ReplyKeyboard getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton(BotMenu.MENU));
        rows.add(row);
        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }

    private static void registerUser(Update update) {
        User from = update.getMessage().getFrom();
        if(!userRepository.existsByChatId(update.getMessage().getChatId())){
            model.User user = new model.User(
                    update.getMessage().getChatId(),
                    from.getFirstName(),
                    from.getLastName(),
                    from.getUserName(),
                    update.getMessage().getContact().getPhoneNumber() != null ? update.getMessage().getContact().getPhoneNumber() : " ",
                    BotState.START
            );


            userService.save(user);
        }
    }
}
