package uz.iDev.dtos.organization;

import lombok.AllArgsConstructor;
import uz.iDev.dtos.GenericBaseDto;

@AllArgsConstructor
public class OrganizationCreateDto implements GenericBaseDto {
    private String name;
    private String website;
    private String email;
    private String logo;
    private Long regNum;
}
