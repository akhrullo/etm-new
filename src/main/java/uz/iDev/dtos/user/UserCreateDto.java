package uz.iDev.dtos.user;

import lombok.AllArgsConstructor;
import uz.iDev.dtos.GenericBaseDto;


@AllArgsConstructor
public class UserCreateDto implements GenericBaseDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String organizationId;
    private String language;
}
