package ru.ywojctb.seminarcrud.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ywojctb.seminarcrud.entities.User;
import ru.ywojctb.seminarcrud.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteUserById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public User findUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
