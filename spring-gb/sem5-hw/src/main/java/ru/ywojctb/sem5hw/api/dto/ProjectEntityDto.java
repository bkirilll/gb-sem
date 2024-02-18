package ru.ywojctb.sem5hw.api.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProjectEntityDto {

    Long id;

    String name;

    String description;

    LocalDate createdDate;

}
