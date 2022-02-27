package uz.iDev.ui;

import uz.iDev.container.UNIContainer;
import uz.iDev.services.project.ProjectServices;
import uz.jl.utils.Input;

public class ProjectUI {
    public static ProjectServices projectServices = UNIContainer.getBean(ProjectServices.class);

    public void addProjectMember() {
        long projectId = Long.parseLong(Input.getStr("Enter project ID: "));
        long memberId = Long.parseLong(Input.getStr("Enter member ID: "));

        Menu.getResponse(projectServices.addMemberToProject(projectId, memberId));
    }

    public void getProjectDetail() {
        Menu.getResponse(projectServices.getProjectDetails(Long.valueOf(Input.getStr("Enter project ID: "))));

    }

    public void createProject() {
        String projectName = Input.getStr("Enter project name: ");
        String projectDescription = Input.getStr("Description : ");
        String projectTZ = Input.getStr("TZ : ");
        String projectBackground = Input.getStr("Background of project : ");
        Long teamLeadId = Long.valueOf(Input.getStr("TeamLead ID: "));


        Menu.getResponse(projectServices.createProject(projectName, projectDescription, projectTZ, projectBackground, teamLeadId));

    }

    public void removeProjectMember() {
        long projectId = Long.parseLong(Input.getStr("Enter project ID: "));
        long memberId = Long.parseLong(Input.getStr("Enter member ID: "));

        Menu.getResponse(projectServices.removeMemberToProject(projectId, memberId));
    }
}
