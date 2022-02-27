package uz.iDev.services.project;

import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.project.ProjectCreateDto;
import uz.iDev.dtos.project.ProjectDto;
import uz.iDev.dtos.project.ProjectUpdateDto;
import uz.iDev.repository.project.ProjectRepository;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.services.AbstractServices;
import uz.iDev.services.GenericCrudServices;
import uz.iDev.services.GenericServices;

import java.util.List;

public class ProjectServices extends AbstractServices<ProjectRepository> implements GenericCrudServices<ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericServices<ProjectDto, GenericCriteria> {

    public ProjectServices(ProjectRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(ProjectCreateDto dto) {
        return new ResponseEntity<>(new Data<>(repository.create(dto)));
    }

    @Override
    public ResponseEntity<Data<ProjectDto>> get(Long id) {
        return new ResponseEntity<>(new Data<>(repository.get(id)));
    }


    @Override
    public ResponseEntity<Data<Boolean>> update(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return null;
    }



    public ResponseEntity<Data<?>> addMemberToProject(long projectId, long memberId) {
        boolean res = repository.addMemberToProject(projectId, memberId);
        return new ResponseEntity<>(new Data<>(res));
    }

    public ResponseEntity<Data<?>> removeMemberToProject(long projectId, long memberId) {
        boolean res = repository.removeMemberToProject(projectId, memberId);
        return new ResponseEntity<>(new Data<>(res));
    }


    @Override
    public ResponseEntity<Data<List<ProjectDto>>> getList(GenericCriteria criteria) {
        return null;
    }
}
