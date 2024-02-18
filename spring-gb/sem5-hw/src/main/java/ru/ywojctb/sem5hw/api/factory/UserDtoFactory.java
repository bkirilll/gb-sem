package ru.ywojctb.sem5hw.api.factory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.ywojctb.sem5hw.api.dto.UserEntityDto;
import ru.ywojctb.sem5hw.store.entities.UserEntity;


@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserDtoFactory {

    public UserEntityDto makeUserDto(UserEntity user) {

        return UserEntityDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}