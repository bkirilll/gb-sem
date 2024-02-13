package ru.ywojctb.seminar3.api.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import ru.ywojctb.seminar3.store.entities.UserEntity;

@Service
@AllArgsConstructor
@Getter
public class RegistrationService {

    private final DataProcessingService dataProcessingService;

    private final UserService userService;

    private final NotificationService notificationService;


    public void createUserFromParams(String name, int age, String email) {

        UserEntity userEntity = userService.createUser(name, age, email);

        dataProcessingService.saveUser(userEntity);
    }

}
