package uz.iDev.dtos.task;

import lombok.AllArgsConstructor;
import uz.iDev.dtos.GenericBaseDto;

@AllArgsConstructor
public class TaskCreateDto implements GenericBaseDto {
    private Long projectId;
    private String name;
    private String description;
    private String deadline;
}
