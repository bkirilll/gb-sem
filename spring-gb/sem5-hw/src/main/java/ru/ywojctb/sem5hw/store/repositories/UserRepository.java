package ru.ywojctb.sem5hw.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ywojctb.sem5hw.store.entities.ProjectEntity;
import ru.ywojctb.sem5hw.store.entities.UserEntity;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Stream<UserEntity> streamAllById(Long aLong);

    Stream<UserEntity> findByProjects_Id(Long id);
}
