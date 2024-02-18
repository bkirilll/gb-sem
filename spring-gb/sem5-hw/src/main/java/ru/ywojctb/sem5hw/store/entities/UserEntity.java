package ru.ywojctb.sem5hw.store.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String userName;

    String password;

    String email;

    String role;

    @ManyToMany(mappedBy = "users")
    List<ProjectEntity> projects = new ArrayList<>();
}
