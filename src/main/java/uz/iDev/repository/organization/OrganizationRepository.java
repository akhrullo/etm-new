package uz.iDev.repository.organization;

import uz.iDev.container.UNIContainer;
import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.organization.OrganizationCreateDto;
import uz.iDev.dtos.organization.OrganizationDto;
import uz.iDev.dtos.organization.OrganizationUpdateDto;
import uz.iDev.property.DatabaseProperties;
import uz.iDev.repository.AbstractRepository;
import uz.iDev.repository.GenericCrudRepository;
import uz.iDev.repository.GenericRepository;
import uz.iDev.security.SecurityHolder;

import java.sql.Types;
import java.util.List;

public class OrganizationRepository extends AbstractRepository implements GenericCrudRepository <OrganizationDto,
        OrganizationCreateDto, OrganizationUpdateDto, Long>,
        GenericRepository <OrganizationDto, GenericCriteria> {

    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);



    @Override
    public Long create(OrganizationCreateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("create.organization"), Types.BIGINT);
    }

    @Override
    public OrganizationDto get(Long id) {
        return null;
    }

    @Override
    public Boolean update(OrganizationUpdateDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrganizationDto> getList(GenericCriteria criteria) {
        return null;
    }
}
