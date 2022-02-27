package uz.iDev.exception;

import lombok.Getter;
import uz.iDev.enums.HttpStatus;

@Getter
public class ApiRuntimeException extends RuntimeException {
    private Integer status;

    public ApiRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status.getCode();
    }
}
