package uz.iDev.ui;

import uz.iDev.dtos.organization.OrganizationCreateDto;
import uz.iDev.dtos.organization.OrganizationUpdateDto;
import uz.iDev.exception.ApiRuntimeException;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.services.auth.AuthUserService;
import uz.iDev.services.organization.OrganizationServices;
import uz.iDev.services.user.UserServices;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.time.LocalDateTime;

public class UI {
    private final AuthUserService authUserService;
    private final UserServices userServices;
    private final OrganizationServices organizationServices;

    public UI(AuthUserService authUserService, UserServices userServices, OrganizationServices organizationServices) {
        this.authUserService = authUserService;
        this.userServices = userServices;
        this.organizationServices = organizationServices;
    }

    public void login() {
        try {
            String username = Input.getStr("username ");
            String password = Input.getStr("password ");
            authUserService.login(username, password);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void userCreate() {
        try {
            String username = Input.getStr("username ");
            String password = Input.getStr("password ");
            authUserService.login(username, password);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void organizationCreate() {
        try {
            String name = Input.getStr("Enter name: ");
            String website = Input.getStr("Enter website: ");
            String logo = Input.getStr("Enter logo: ");
            Long regNumber = Long.valueOf(Input.getStr("Enter regNumber: "));

            String email = Input.getStr("Enter email: ");
            OrganizationCreateDto dto = new OrganizationCreateDto(name, website, email, logo, regNumber );
            ResponseEntity<Data<Long>> response = organizationServices.create(dto);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void deleteOrganization() {
        try {
            long orgId = (long) Input.getNum("Organization ID : ");
            organizationServices.delete(orgId);
            showResponse(Color.GREEN, "Success");
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void organizationUpdate() {
        try {
            OrganizationUpdateDto dto = new OrganizationUpdateDto();
            long organizationId = (long) Input.getNum("Organization Id : ");
            String email = Input.getStr("Email : ");
            String website = Input.getStr("Website : ");
            String logo = Input.getStr("Logo : ");
            String location = Input.getStr("Location : ");
            dto.setEmail(email);
            dto.setLocation(location);
            dto.setWebsite(website);
            dto.setLogo(logo);
            dto.setId(organizationId);
            organizationServices.update(dto);
            showResponse(Color.GREEN, "Success");
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void userBlock() {
        Long userId = (long) Input.getNum("UserID : ");
        String reason = Input.getStr("Reason : ");
        BlockDto blockDto = new BlockDto(userId, reason, LocalDateTime.now().plusDays(1));
        userServices.block(blockDto);
    }

    public void userDelete() {
        try {
            Long userid = (long) Input.getNum("UserID: ");
            userServices.delete(userid);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    private <T> void showResponse(String color, T response) {
        Print.println(color, response);
    }

    private <T> void showResponse(T response) {
        showResponse(Color.RED, response);
    }
}
