package uz.iDev.services.auth;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.user.UserCreateDto;
import uz.iDev.dtos.user.UserDto;
import uz.iDev.exception.ApiRuntimeException;
import uz.iDev.exception.CustomerSQLException;
import uz.iDev.repository.auth.AuthUserRepository;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.security.SecurityHolder;
import uz.iDev.services.AbstractServices;
import uz.iDev.services.GenericServices;

import java.util.List;

public class AuthUserService extends AbstractServices<AuthUserRepository> implements GenericServices {

    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    @Override
    public void block(UserDto blockDto) {

    }

    public ResponseEntity<Data<Boolean>> login(String userName, String password) {
        try {
            SecurityHolder.session = repository.login(userName, password);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }


    @Override
    public ResponseEntity<Data<List>> getList(GenericCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<?>> create(UserCreateDto dto) {
        return null;
    }
}
