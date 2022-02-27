package uz.iDev.repository.task;

import uz.iDev.container.UNIContainer;
import uz.iDev.dtos.task.TaskCreateDto;
import uz.iDev.property.DatabaseProperties;
import uz.iDev.repository.BaseRepository;
import uz.iDev.security.SecurityHolder;
import uz.iDev.utils.BaseUtils;

import java.sql.Types;

public class TaskRepository extends BaseRepository {
    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public Long createTask(Long projectId, String name, String description, String deadline) {
        prepareArguments(BaseUtils.gson.toJson(new TaskCreateDto(projectId, name, description, deadline)), SecurityHolder.session.getId());
        String res = "" + callProcedure(property.get("create.task"), Types.BIGINT);
        return Long.valueOf(res);
    }

    public String getTaskDetails(Long taskId) {
        prepareArguments(taskId);
        return "" + callProcedure(property.get("task.details"), Types.VARCHAR);
    }

    public boolean addTaskMember(long taskId, long memberId) {
        prepareArguments(taskId, memberId, SecurityHolder.session.getId());
        String res = "" + callProcedure(property.get("add.task.member"), Types.BOOLEAN);
        return Boolean.parseBoolean(res);
    }

    public boolean removeTaskMember(long taskId, long memberId) {
        prepareArguments(taskId, memberId, SecurityHolder.session.getId());
        String res = "" + callProcedure(property.get("remove.task.member"), Types.BOOLEAN);
        return Boolean.parseBoolean(res);

    }

    public String setProcess(String process, long taskId) {
        prepareArguments(process, taskId, SecurityHolder.session.getId());
        return "" + callProcedure(property.get("set.process"), Types.BIGINT);

    }
}
