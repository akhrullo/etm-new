package uz.iDev.ui;

import uz.iDev.container.UNIContainer;
import uz.iDev.dtos.organization.OrganizationCreateDto;
import uz.iDev.services.organization.OrganizationServices;
import uz.jl.utils.Input;

public class OrganizationUI {
    public static OrganizationServices organizationServices = UNIContainer.getBean(OrganizationServices.class);

    public void createOrganization() {
        String organizationName = Input.getStr("Enter organization name: ");
        String organizationWebsite = Input.getStr("Website : ");
        String organizationEmail = Input.getStr("Email : ");
        String organizationLogo = Input.getStr("Logo of organization : ");
        Long regNum = Long.valueOf(Input.getStr("Registration number : "));

        Menu.getResponse(organizationServices.createOrganization(new OrganizationCreateDto(organizationName, organizationWebsite, organizationEmail, organizationLogo, regNum)));

    }

    public void createAdmin() {
        AuthUserUI.createUser();
    }
}
