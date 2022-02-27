package uz.iDev.container;

import uz.iDev.property.ApplicationProperties;
import uz.iDev.property.DatabaseProperties;
import uz.iDev.repository.auth.AuthUserRepository;
import uz.iDev.repository.organization.OrganizationRepository;
import uz.iDev.repository.project.ProjectRepository;
import uz.iDev.repository.task.TaskRepository;
import uz.iDev.repository.user.UserRepository;
import uz.iDev.services.auth.AuthUserService;
import uz.iDev.services.organization.OrganizationServices;
import uz.iDev.services.project.ProjectServices;
import uz.iDev.services.task.TaskServices;
import uz.iDev.services.user.UserServices;
import uz.iDev.ui.OrganizationUI;
import uz.iDev.ui.ProjectUI;
import uz.iDev.ui.TaskUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;
    private final static AuthUserRepository AUTH_USER_REPOSITORY;
    private final static UserRepository USER_REPOSITORY;
    private static final ProjectRepository PROJECT_REPOSITORY;
    private static final TaskRepository TASK_REPOSITORY;
    private final static AuthUserService AUTH_USER_SERVICE;
    private final static UserServices USER_SERVICE;
    private static final ProjectServices PROJECT_SERVICES;
//    private static final AuthUserUI AUTH_USER_UI;
    private static final ProjectUI PROJECT_UI;
    private static final TaskUI TASK_UI;
    private static final TaskServices TASK_SERVICES;
    private static final OrganizationRepository ORGANIZATION_REPOSITORY;
    private static final OrganizationServices ORGANIZATION_SERVICES;
    private static final OrganizationUI ORGANIZATION_UI;

    static {
        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AUTH_USER_REPOSITORY = new AuthUserRepository();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);
        USER_REPOSITORY = new UserRepository();
        USER_SERVICE = new UserServices(USER_REPOSITORY);
        PROJECT_REPOSITORY = new ProjectRepository();
        PROJECT_SERVICES = new ProjectServices(PROJECT_REPOSITORY);
//        AUTH_USER_UI = new AuthUserUI(AUTH_USER_SERVICE);
        PROJECT_UI = new ProjectUI();
        TASK_REPOSITORY = new TaskRepository();
        TASK_SERVICES = new TaskServices(TASK_REPOSITORY);
        TASK_UI = new TaskUI();
        ORGANIZATION_REPOSITORY = new OrganizationRepository();
        ORGANIZATION_SERVICES = new OrganizationServices(ORGANIZATION_REPOSITORY);
        ORGANIZATION_UI = new OrganizationUI();
    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;
            case "ORGANIZATIONREPOSITORY" -> (T) ORGANIZATION_REPOSITORY;
            case "ORGANIZATIONSERVICES" -> (T) ORGANIZATION_SERVICES;
            case "ORGANIZATIONUI" -> (T) ORGANIZATION_UI;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "USERREPOSITORY" -> (T) USER_REPOSITORY;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "USERSERVICE" -> (T) USER_SERVICE;
            case "TASKSERVICES" -> (T) TASK_SERVICES;
            case "PROJECTSERVICES" -> (T) PROJECT_SERVICES;
//            case "AUTHUSERUI" -> (T) AUTH_USER_UI;
            case "PROJECTUI" -> (T) PROJECT_UI;
            case "TASKUI" -> (T) TASK_UI;

            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
