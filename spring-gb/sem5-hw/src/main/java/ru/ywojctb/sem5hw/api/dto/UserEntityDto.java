package ru.ywojctb.sem5hw.api.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserEntityDto {

    Long id;

    String userName;

    String password;

    String email;

    String role;

}
