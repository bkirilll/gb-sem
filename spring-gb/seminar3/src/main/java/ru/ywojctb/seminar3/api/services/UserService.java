package ru.ywojctb.seminar3.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ywojctb.seminar3.store.entities.UserEntity;
import ru.ywojctb.seminar3.store.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final NotificationService notificationService;

    public UserEntity createUser(String name, int age, String email) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setEmail(email);

        notificationService.notifyUser(userEntity);

        return userEntity;
    }


}
