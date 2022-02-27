package uz.iDev;

import uz.iDev.container.UNIContainer;
import uz.iDev.security.SecurityHolder;
import uz.iDev.ui.*;
import uz.jl.utils.Input;

public class Application {
    public static AuthUserUI authUserUI = UNIContainer.getBean(AuthUserUI.class);
    public static ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
    public static TaskUI taskUI = UNIContainer.getBean(TaskUI.class);
    public static OrganizationUI orgUI = UNIContainer.getBean(OrganizationUI.class);


    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }

    }

    private static void run() {
        Menu.getMainMenu();

        String choice = Input.getStr("Your choice :  ");

        switch (choice.toUpperCase()) {
            case "LOGIN" ->  authUserUI.login();
            case "SET_ROLE" ->  authUserUI.setRole();
            case "SET_PERMISSION" ->  authUserUI.setPermission();
            case "CREATE_USER" ->  authUserUI.createUser();
            case "USER_INFO" ->  authUserUI.userInfo();
            case "ADD_PROJECT_MEMBER" ->  projectUI.addProjectMember();
            case "REMOVE_PROJECT_MEMBER" ->  projectUI.removeProjectMember();
            case "CREATE_PROJECT" ->  projectUI.createProject();
            case "PROJECT_DETAIL" -> projectUI.getProjectDetail();
            case "CREATE_TASK" ->  taskUI.createTask();
            case "ADD_TASK_MEMBER" ->  taskUI.addTaskMember();
            case "REMOVE_TASK_MEMBER" ->  taskUI.removeTaskMember();
            case "SET_PROCESS" ->  taskUI.setProcess();
            case "TASK_DETAIL" ->  taskUI.getTaskDetails();
            case "CREATE_ORGANIZATION" -> orgUI.createOrganization();

            case "LOGOUT" -> {
                SecurityHolder.removeSession();
                System.out.println("\n");
                run();
            }

            case "EXIT" ->    {
                return;
            }

            default -> {
                System.out.println("Wrong choice ...");
            }
        }

        System.out.println("\n");

         run();
    }
}
