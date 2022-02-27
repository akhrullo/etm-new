package uz.iDev.repository.user;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.GenericDto;
import uz.iDev.dtos.user.UserCreateDto;
import uz.iDev.dtos.user.UserDto;
import uz.iDev.dtos.user.UserUpdateDto;
import uz.iDev.repository.AbstractRepository;
import uz.iDev.repository.GenericCrudRepository;
import uz.iDev.repository.GenericRepository;
import uz.iDev.security.SecurityHolder;
import uz.iDev.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class UserRepository extends AbstractRepository implements GenericCrudRepository<UserDto,
        UserCreateDto,
        UserUpdateDto,
        Long>, GenericRepository<GenericDto, GenericCriteria> {
    @Override
    public Long create(UserCreateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.session.getId());

        return (Long) callProcedure(property.get("create.user"), Types.BIGINT);
    }

    @Override
    public UserDto get(Long id) {
        prepareArguments(SecurityHolder.session.getId());
        return gson.fromJson((String) callProcedure(property.get("user.info"), Types.VARCHAR), UserDto.class);
    }

    @Override
    public Boolean update(UserUpdateDto dto) {
        return false;
    }

    @Override
    public void delete(Long id) {
        prepareArguments(id, SecurityHolder.session.getId());
        callProcedure(property.get("user.delete"), Types.BOOLEAN);
    }

    @Override
    public List<GenericDto> getList(GenericCriteria criteria) {
        return null;
    }

    public Boolean setRole(Long roleId, Long userId) {
        prepareArguments(roleId, userId, SecurityHolder.session.getId());
        String res = "" + callProcedure(property.get("set.role"), Types.BOOLEAN);
        return Boolean.valueOf(res);

    }

    public Boolean setPermission(Long permissionId, Long userId) {
        prepareArguments(permissionId, userId, SecurityHolder.session.getId());
        return (Boolean) callProcedure(property.get("set.permission"), Types.BOOLEAN);

    }

    public Long createAdmin(UserCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.session.getId());

        return (Long) callProcedure(property.get("create.admin"), Types.BIGINT);
    }
}
