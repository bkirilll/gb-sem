package ru.ywojctb.sem5hw.api.controllers;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ru.ywojctb.sem5hw.api.dto.ProjectEntityDto;
import ru.ywojctb.sem5hw.api.dto.UserEntityDto;
import ru.ywojctb.sem5hw.api.services.UserProjectService;
import ru.ywojctb.sem5hw.store.entities.ProjectEntity;
import ru.ywojctb.sem5hw.store.entities.UserEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class UserProjectController {

    UserProjectService userProjectService;


    @GetMapping("/users/{project_id}")
    public List<UserEntityDto> getAllUsersByProject(@PathVariable(name = "project_id") Long projectId) {
        return userProjectService.getUsersByProjectId(projectId);
    }

    @GetMapping("/projects/{user_id}")
    public List<ProjectEntityDto> getAllProjectsByUser(@PathVariable(name = "user_id") Long userId) {
        return userProjectService.getProjectsByUserId(userId);
    }

    @PostMapping("/user-add-to-project")
    public void addUserToProject(@RequestParam(name = "userId") Long userId,
                                 @RequestParam(name = "projectId") Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
    }

    @PostMapping("/user-delete-from-project")
    public void deleteUserFromProject(@RequestParam(name = "userId") Long userId,
                                 @RequestParam(name = "projectId") Long projectId) {
        userProjectService.deleteUserFromProject(userId, projectId);
    }

    @PostMapping("/user-add")
    @ResponseBody
    public void addUser(@RequestBody UserEntity user) {
        userProjectService.saveUser(user);
    }

    @PostMapping("/project-add")
    @ResponseBody
    public void addProject(@RequestBody ProjectEntity project) {
        userProjectService.saveProject(project);
    }

}
