package ru.ywojctb.sem5hw.api.services;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.ywojctb.sem5hw.api.dto.ProjectEntityDto;
import ru.ywojctb.sem5hw.api.dto.UserEntityDto;
import ru.ywojctb.sem5hw.api.exceptions.BadRequestException;
import ru.ywojctb.sem5hw.api.factory.ProjectDtoFactory;
import ru.ywojctb.sem5hw.api.factory.UserDtoFactory;
import ru.ywojctb.sem5hw.store.entities.ProjectEntity;
import ru.ywojctb.sem5hw.store.entities.UserEntity;
import ru.ywojctb.sem5hw.store.repositories.ProjectRepository;
import ru.ywojctb.sem5hw.store.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class UserProjectService {

    ProjectRepository projectRepository;

    UserRepository userRepository;

    ProjectDtoFactory projectDtoFactory;

    UserDtoFactory userDtoFactory;

    public void saveUser(UserEntity user) {
        userRepository.saveAndFlush(user);
    }

    public void saveProject(ProjectEntity project) {
        projectRepository.saveAndFlush(project);
    }

    public List<UserEntityDto> getUsersByProjectId(Long projectId) {

        ProjectEntity project = getProjectEntityOrThrowException(projectId);

        Stream<UserEntity> users = userRepository.findByProjects_Id(project.getId());

        return users
                .map(userDtoFactory::makeUserDto)
                .collect(Collectors.toList());
    }

    public List<ProjectEntityDto> getProjectsByUserId(Long userId) {

        UserEntity user = getUserEntityOrThrowException(userId);

        Stream<ProjectEntity> projects = projectRepository.findByUsers_Id(user.getId());

        return projects
                .map(projectDtoFactory::makeProjectDto)
                .collect(Collectors.toList());
    }

    public void addUserToProject(Long userId, Long projectId) {

        ProjectEntity project = getProjectEntityOrThrowException(projectId);

        UserEntity user = getUserEntityOrThrowException(userId);

        user.getProjects().add(project);

        project.getUsers().add(user);

        userRepository.saveAndFlush(user);

        projectRepository.saveAndFlush(project);


    }

    public void deleteUserFromProject(Long userId, Long projectId) {

        ProjectEntity project = getProjectEntityOrThrowException(projectId);

        UserEntity user = getUserEntityOrThrowException(userId);

        project.getUsers().remove(user);

        userRepository.saveAndFlush(user);

        projectRepository.saveAndFlush(project);
    }

    private UserEntity getUserEntityOrThrowException(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Bad id"));
    }

    private ProjectEntity getProjectEntityOrThrowException(Long id) {
        return projectRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Bad id"));
    }


}
