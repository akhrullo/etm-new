package uz.iDev.services.user;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.user.UserCreateDto;
import uz.iDev.dtos.user.UserDto;
import uz.iDev.dtos.user.UserUpdateDto;
import uz.iDev.repository.user.UserRepository;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.services.AbstractServices;
import uz.iDev.services.GenericCrudServices;
import uz.iDev.services.GenericServices;

import java.util.List;

public class UserServices extends AbstractServices <UserRepository> implements GenericCrudServices <UserDto,
        UserCreateDto,
        UserUpdateDto,
        Long>,
        GenericServices <UserDto, GenericCriteria> {

    public UserServices(UserRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(UserCreateDto dto) {
        Long response;
        if(hasPermission("CREATE_ADMIN")) {
            response = repository.createAdmin(dto);
        }
        else {
            response = repository.create(dto);

        }
        return new ResponseEntity<>(new Data<>(response));

    }

    @Override
    public ResponseEntity<Data<UserDto>> get(Long id) {
        return new ResponseEntity<>(new Data<>(repository.get(id)));
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> getList(GenericCriteria criteria) {
        return null;
    }



    public ResponseEntity<Data<Boolean>> setRole(Long roleId, Long userId) {
        Boolean response = repository.setRole(roleId, userId);
        return new ResponseEntity<>(new Data<>(response));
    }

    public ResponseEntity<Data<Boolean>> setPermission(Long permissionId, Long userId) {
        Boolean response = repository.setRole(permissionId, userId);
        return new ResponseEntity<>(new Data<>(response));
    }
}
