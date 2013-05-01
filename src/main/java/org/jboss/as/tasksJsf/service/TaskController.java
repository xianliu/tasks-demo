package org.jboss.as.tasksJsf.service;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.as.tasksJsf.data.access.TaskDao;
import org.jboss.as.tasksJsf.data.access.TaskList;
import org.jboss.as.tasksJsf.data.model.Task;
import org.jboss.as.tasksJsf.data.model.User;
import org.jboss.as.tasksJsf.qualifier.CurrentUser;

@RequestScoped
@Named
public class TaskController {

    @Inject
    private TaskDao taskDao;

    @Inject
    private TaskList taskList;

    @Inject
    @CurrentUser
    private Instance<User> currentUser;

    @Inject
    private CurrentTaskStore currentTaskStore;

    public void setCurrentTask(Task task) {
        currentTaskStore.set(task);
    }

    public void createTask(String taskTitle) {
        taskList.invalidate();
        Task task = new Task(taskTitle);
        taskDao.createTask(currentUser.get(), task);
        if (currentTaskStore.get() == null) {
            currentTaskStore.set(task);
        }
    }

    public void deleteTask(Task task) {
        taskList.invalidate();
        if (task.equals(currentTaskStore.get())) {
            currentTaskStore.unset();
        }
        taskDao.deleteTask(task);
    }

    public void deleteCurrentTask() {
        deleteTask(currentTaskStore.get());
    }
}
