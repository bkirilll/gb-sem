package ru.ywojctb.seminar3.api.services;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import ru.ywojctb.seminar3.store.entities.UserEntity;
import ru.ywojctb.seminar3.store.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DataProcessingService {

    private final UserRepository userRepository;

    public void saveUser(UserEntity userEntity) {
        userRepository.saveAndFlush(userEntity);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserEntity> filterUserByAge(List<UserEntity> users, int age) {
        return users.stream()
                .filter(userEntity -> userEntity.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAvgUserAge(List<UserEntity> users) {
        return users.stream()
                .mapToInt(UserEntity::getAge)
                .average()
                .orElse(0);
    }

    public List<UserEntity> sortUserByAge(List<UserEntity> users) {
        return users.stream()
                .sorted(Comparator.comparing(UserEntity::getAge))
                .collect(Collectors.toList());
    }
}
