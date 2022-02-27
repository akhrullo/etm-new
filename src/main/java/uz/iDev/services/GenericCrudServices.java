package uz.iDev.services;

import uz.iDev.dtos.GenericBaseDto;
import uz.iDev.dtos.GenericDto;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;

import java.io.Serializable;

public interface GenericCrudServices <D extends GenericDto,
        CD extends GenericBaseDto,
        UD extends GenericDto,
        K extends Serializable> {
    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<D>> get(K id);

    ResponseEntity<Data<Boolean>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);
}
