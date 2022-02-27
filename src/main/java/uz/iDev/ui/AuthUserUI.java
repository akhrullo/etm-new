package uz.iDev.ui;

import uz.iDev.dtos.user.UserCreateDto;
import uz.iDev.enums.HttpStatus;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.security.SecurityHolder;
import uz.iDev.services.auth.AuthUserService;
import uz.iDev.utils.BaseUtils;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class AuthUserUI extends BaseUI<AuthUserService>{

    protected AuthUserUI(AuthUserService service) {
        super(service);
    }

    public void login() {

        String username = Input.getStr("Username : ");
        String password = Input.getStr("Password : ");

        ResponseEntity<Data<Boolean>> response = service.login(username, password);

        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            System.out.println(response.getBody().getData());
        } else {
            System.out.println(BaseUtils.gson.toJson(SecurityHolder.session));

            SecurityHolder.setSession(SecurityHolder.session);

        }
    }

    public void setRole() {
        String userId = Input.getStr("User ID: ");
        String roleId = Input.getStr("Role ID: ");

        Menu.getResponse(service.setRole(Long.valueOf(roleId), Long.valueOf(userId)));
    }

    public static void createUser() {
        String userName = Input.getStr("Enter  userName: ");
        String password = Input.getStr("Enter  password: ");
        String email = Input.getStr("Email : ");
        String phone = Input.getStr("Phone Number : ");
        String firstName = Input.getStr("Firstname : ");
        String lastName = Input.getStr("Lastname : ");
        String organizationId = (Input.getStr("OrganizationId : "));
        String language = Input.getStr("Language : ");

        UserCreateDto authUserCreateDto = new UserCreateDto(userName, password, email, phone, firstName, lastName, organizationId, language);
        Menu.getResponse(service.createUser(authUserCreateDto));

    }



    @Override
    public void create() {
        int organizationId = Input.getNum("Enter organization ID: ");
        String username = Input.getStr("Enter username: ");
        String password = Input.getStr("Enter password: ");
        String firsName = Input.getStr("Enter firsName: ");
        String lastName = Input.getStr("Enter lastName: ");
        String phone = Input.getStr("Enter phone: ");
        String email = Input.getStr("Enter email: ");
        String language = Input.getStr("Enter language: ");
        UserCreateDto dto = new UserCreateDto(password, phone, organizationId, lastName, language, firsName, email, username);
        ResponseEntity<Data<?>> response = service.create(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Success");
        }
    }


    @Override
    public void unblock() {

    }

    @Override
    public void get() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void getList() {

    }
}
