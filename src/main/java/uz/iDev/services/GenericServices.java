package uz.iDev.services;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.GenericDto;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;

import java.util.List;

/**
 *
 * @param <D> dto
 * @param <C> criteria
 */

public interface GenericServices <D extends GenericDto, C extends GenericCriteria> {
    ResponseEntity<Data<List<D>>> getList(C criteria);
}
