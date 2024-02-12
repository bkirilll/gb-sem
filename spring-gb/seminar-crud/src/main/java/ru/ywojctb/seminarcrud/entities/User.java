package ru.ywojctb.seminarcrud.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String firstName;

    String lastName;
}
