package ru.ywojctb.seminar3.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ywojctb.seminar3.store.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
