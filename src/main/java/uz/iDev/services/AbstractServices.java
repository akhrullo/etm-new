package uz.iDev.services;

import uz.iDev.repository.AbstractRepository;
import uz.iDev.security.PermissionsItem;
import uz.iDev.security.RolesItem;
import uz.iDev.security.SecurityHolder;
import uz.iDev.security.SessionUser;

import java.util.List;
import java.util.Objects;

public abstract class AbstractServices <R extends AbstractRepository> {
    protected final R repository;

    public AbstractServices(R repository) {
        this.repository = repository;
    }

    protected boolean hasRole(String role) {
        SessionUser session = SecurityHolder.session;
        if (Objects.isNull(session)) return false;
        List<RolesItem> roles = session.getRoles();
        if (Objects.isNull(roles)) return false;
        return roles.stream().anyMatch(r -> r.getCode().equalsIgnoreCase(role));
    }

    protected boolean hasPermission(String permission) {
        SessionUser session = SecurityHolder.session;
        if (Objects.isNull(session)) return false;
        List<PermissionsItem> permissions = session.getPermissions();
        if (Objects.isNull(permissions)) return false;
        return permissions.stream().anyMatch(p -> p.getCode().equalsIgnoreCase(permission));
    }

}
