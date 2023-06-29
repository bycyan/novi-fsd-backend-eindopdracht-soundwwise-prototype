package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.sevices;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Task;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    private final List<Task> tasks = new ArrayList<>();

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void updateTask(Task task) {
        if (task.isComplete()) {
            // Task is completed, you can perform additional logic here if needed
            // For example, you can send a notification or perform some post-completion actions
        }
        // No additional logic required as the task object in the list is already updated.
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }
}
