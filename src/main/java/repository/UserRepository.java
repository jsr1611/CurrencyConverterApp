package repository;

import org.telegram.telegrambots.meta.api.objects.User;

public interface UserRepository{
    boolean existsByChatId(Long chatId);
}
