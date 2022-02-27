package uz.iDev.repository.project;

import com.google.gson.JsonElement;
import uz.iDev.container.UNIContainer;
import uz.iDev.criterias.GenericCriteria;
import uz.iDev.dtos.project.ProjectCreateDto;
import uz.iDev.dtos.project.ProjectDto;
import uz.iDev.dtos.project.ProjectUpdateDto;
import uz.iDev.property.DatabaseProperties;
import uz.iDev.repository.AbstractRepository;
import uz.iDev.repository.GenericCrudRepository;
import uz.iDev.repository.GenericRepository;
import uz.iDev.security.SecurityHolder;

import java.sql.Types;
import java.util.List;

public class ProjectRepository extends AbstractRepository implements GenericCrudRepository<ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericRepository<ProjectDto, GenericCriteria> {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);



    public Boolean addMemberToProject(long projectId, long memberId){
        prepareArguments(projectId, memberId, SecurityHolder.session.getId());

        return (Boolean) callProcedure(property.get("add.project.member"), Types.BOOLEAN);
    }

    public Boolean removeMemberToProject(long projectId, long memberId){
        prepareArguments(projectId, memberId);

        return (Boolean) callProcedure(property.get("remove.project.member"), Types.BOOLEAN);
    }


    @Override
    public Long create(ProjectCreateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("create.project"), Types.BIGINT);
    }

    @Override
    public ProjectDto get(Long id) {
        prepareArguments(id, SecurityHolder.session.getId());
        return gson.fromJson((JsonElement) callProcedure(property.get("project.details"), Types.VARCHAR), ProjectDto.class);
    }

    @Override
    public Boolean update(ProjectUpdateDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProjectDto> getList(GenericCriteria criteria) {
        return null;
    }
}
