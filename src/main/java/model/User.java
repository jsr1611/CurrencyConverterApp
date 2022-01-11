package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.enums.BotState;
import org.checkerframework.checker.signature.qual.Identifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private Long chatId;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private BotState botState;

    public User(Long chatId, String firstName, String lastName, String userName, String phoneNumber, BotState state) {
        this.chatId = chatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.botState = state;
    }
}
