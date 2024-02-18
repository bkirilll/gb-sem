package ru.ywojctb.sem5hw.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ywojctb.sem5hw.store.entities.ProjectEntity;
import ru.ywojctb.sem5hw.store.entities.UserEntity;

import java.util.List;
import java.util.stream.Stream;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    Stream<ProjectEntity> streamAllById(Long id);

    Stream<ProjectEntity> findByUsers_Id(Long id);

}
