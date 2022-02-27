package uz.iDev.services.task;

import uz.iDev.dtos.task.TaskCreateDto;
import uz.iDev.dtos.task.TaskDto;
import uz.iDev.repository.task.TaskRepository;
import uz.iDev.response.Data;
import uz.iDev.response.ResponseEntity;
import uz.iDev.services.BaseService;

public class TaskServices extends BaseService<TaskRepository, TaskCreateDto, TaskDto, Long > {
    public TaskServices(TaskRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Long> create(TaskCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> get(Long id) {
        return null;
    }

    public ResponseEntity<Data<?>> addTaskMember(long taskId, long memberId) {
        boolean res = repository.addTaskMember(taskId, memberId);
        return new ResponseEntity<>(new Data<>(res));
    }

    public ResponseEntity<Data<?>> removeTaskMember(long taskId, long memberId) {
        boolean res = repository.removeTaskMember(taskId, memberId);
        return new ResponseEntity<>(new Data<>(res));
    }

    public ResponseEntity<Data<?>> getTaskDetails(Long taskId) {
        String res = repository.getTaskDetails(taskId);
        return new ResponseEntity<>(new Data<>(res));
    }

    public ResponseEntity<Data<?>> setProcess(String process, long taskId) {
        String res = repository.setProcess(process, taskId);
        return new ResponseEntity<>(new Data<>(res));

    }

    public ResponseEntity<Data<?>> createTask(Long projectId, String name, String description, String deadline) {
        Long res = repository.createTask(projectId, name, description, deadline);
        return new ResponseEntity<>(new Data<>(res));
    }
}
