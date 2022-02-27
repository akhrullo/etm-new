package uz.iDev.ui;

import uz.iDev.container.UNIContainer;
import uz.iDev.services.task.TaskServices;
import uz.jl.utils.Input;

public class TaskUI {
    public static TaskServices taskServices = UNIContainer.getBean(TaskServices.class);


    public void setProcess() {
        String process = Input.getStr("Enter process code: ");
        long taskId = Long.parseLong(Input.getStr("Task ID: "));

        Menu.getResponse(taskServices.setProcess(process, taskId));

    }

    public void getTaskDetails() {
        Menu.getResponse(taskServices.getTaskDetails(Long.valueOf(Input.getStr("Enter task ID: "))));
    }

    public void createTask() {
        Long projectId = Long.valueOf(Input.getStr("Enter project ID: "));
        String name = Input.getStr("Name of new Task: ");
        String description = Input.getStr("Description: ");
        String deadline = Input.getStr("Deadline:  ");

        Menu.getResponse(taskServices.createTask(projectId, name, description, deadline));
    }

    public void addTaskMember() {
        long taskId = Long.parseLong(Input.getStr("Enter task ID: "));
        long memberId = Long.parseLong(Input.getStr("Enter member ID: "));

        Menu.getResponse(taskServices.addTaskMember(taskId, memberId));
    }

    public void removeTaskMember() {
        long taskId = Long.parseLong(Input.getStr("Enter task ID: "));
        long memberId = Long.parseLong(Input.getStr("Enter member ID: "));

        Menu.getResponse(taskServices.removeTaskMember(taskId, memberId));
    }
}
