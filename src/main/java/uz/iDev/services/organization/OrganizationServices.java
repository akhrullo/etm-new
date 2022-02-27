package uz.iDev.services.organization;

import uz.iDev.dtos.organization.OrganizationCreateDto;
import uz.iDev.dtos.organization.OrganizationDto;
import uz.iDev.dtos.organization.OrganizationUpdateDto;
import uz.iDev.repository.organization.OrganizationRepository;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.services.AbstractServices;
import uz.iDev.services.GenericCrudServices;

public class OrganizationServices extends AbstractServices<OrganizationRepository> implements GenericCrudServices<OrganizationDto, OrganizationCreateDto, OrganizationUpdateDto, Long> {


    public OrganizationServices(OrganizationRepository organizationRepository) {
        super(organizationRepository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(OrganizationCreateDto dto) {
        return new ResponseEntity<>(new Data<>(repository.create(dto)));
    }

    @Override
    public ResponseEntity<Data<OrganizationDto>> get(Long id) {
        return new ResponseEntity<>(new Data<>(repository.get(id)));
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(OrganizationUpdateDto dto) {
        return new ResponseEntity<>(new Data<>(repository.update(dto)));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
       repository.delete(id);
       return new ResponseEntity<>(new Data<>(null));
    }
}
