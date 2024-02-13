package ru.ywojctb.seminar3.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ywojctb.seminar3.api.services.RegistrationService;
import ru.ywojctb.seminar3.store.entities.UserEntity;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final RegistrationService registrationService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return registrationService.getDataProcessingService().getAllUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody UserEntity userEntity) {
        registrationService.getDataProcessingService().saveUser(userEntity);

        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "email") String email) {

        registrationService.createUserFromParams(name, age, email);

        return "User added from params!";
    }


}
