package ru.ywojctb.seminar3.api.services;

import org.springframework.stereotype.Service;
import ru.ywojctb.seminar3.store.entities.UserEntity;

@Service
public class NotificationService {

    public void notifyUser(UserEntity userEntity) {
        System.out.println("A new user has been created: " + userEntity + ".");
    }

    public void sendNotification(String message) {
        System.out.println(message);
    }
}
