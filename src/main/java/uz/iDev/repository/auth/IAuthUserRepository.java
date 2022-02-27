package uz.iDev.repository.auth;

import uz.iDev.security.SessionUser;

public interface IAuthUserRepository {
    SessionUser login(String username, String password);
    Boolean isLeader(long projectId, long userId);
}
