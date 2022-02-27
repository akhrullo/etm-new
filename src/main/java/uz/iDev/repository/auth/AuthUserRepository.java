package uz.iDev.repository.auth;

import uz.iDev.container.UNIContainer;
import uz.iDev.property.DatabaseProperties;
import uz.iDev.repository.AbstractRepository;
import uz.iDev.security.SessionUser;

import java.sql.Types;

public class AuthUserRepository extends AbstractRepository implements IAuthUserRepository{
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    @Override
    public SessionUser login(String userName, String password) {
        prepareArguments(userName,password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return gson.fromJson(jsonDATA, SessionUser.class);
    }

    @Override
    public Boolean isLeader(long projectId, long userId) {
        prepareArguments(projectId, userId);
        return (Boolean) callProcedure(property.get("auth.isLead"), Types.BOOLEAN);
    }


}
