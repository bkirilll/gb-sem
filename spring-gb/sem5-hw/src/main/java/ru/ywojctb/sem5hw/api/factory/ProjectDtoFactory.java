package ru.ywojctb.sem5hw.api.factory;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.ywojctb.sem5hw.api.dto.ProjectEntityDto;
import ru.ywojctb.sem5hw.store.entities.ProjectEntity;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectDtoFactory {

    UserDtoFactory userDtoFactory;

    public ProjectEntityDto makeProjectDto(ProjectEntity project) {

        return ProjectEntityDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .createdDate(project.getCreatedDate())
                .build();
    }
}
