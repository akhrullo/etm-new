package uz.iDev.dtos.project;

import lombok.AllArgsConstructor;
import uz.iDev.dtos.GenericBaseDto;

@AllArgsConstructor
public class ProjectCreateDto implements GenericBaseDto {
    private String name;
    private String description;
    private String tz;
    private String background;
    private Long teamLead;

}
