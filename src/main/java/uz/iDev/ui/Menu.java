package uz.iDev.ui;

import uz.iDev.enums.HttpStatus;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.security.PermissionsItem;
import uz.iDev.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

import static uz.iDev.security.SecurityHolder.permissions;

public class Menu {


    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.session)) {
            Print.println(Color.BLUE, "Login -> LOGIN");
        } else {
            for (PermissionsItem permission : permissions) {
                Print.println(Color.BLUE, permission.getName() + " -> " + permission.getCode());
            }

            Print.println("Logout -> LOGOUT");
        }
        Print.println(Color.BLUE, "Exit -> EXIT");

    }

    public static void getResponse(ResponseEntity<Data<?>> responseEntity) {

        if (!responseEntity.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            System.out.println(responseEntity.getBody().getData());
        } else {
            System.out.println("RESPONSE : " + responseEntity.getBody().getData());
        }

    }
}
