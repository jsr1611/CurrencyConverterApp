package repository;

import main.config.DbConfig;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository{

    @Override
    public boolean existsByChatId(Long chatId) {
        String SELECT_USER_BY_CHAT_ID = "SELECT * FROM users WHERE chat_id = " + chatId;
        try {
            PreparedStatement statement = connection.preparedStatement(SELECT_USER_BY_CHAT_ID);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
