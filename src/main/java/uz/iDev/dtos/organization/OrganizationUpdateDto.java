package uz.iDev.dtos.organization;

import lombok.Data;
import uz.iDev.dtos.GenericDto;

@Data
public class OrganizationUpdateDto extends GenericDto {
    private String website;
    private String name;
    private String logo;
    private String  location;
    private String email;
}
