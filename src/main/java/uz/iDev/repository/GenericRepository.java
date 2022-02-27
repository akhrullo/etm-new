package uz.iDev.repository;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.GenericDto;

import java.util.List;

public interface GenericRepository<D extends GenericDto, C extends GenericCriteria> {
    List<D> getList (C criteria);
}
