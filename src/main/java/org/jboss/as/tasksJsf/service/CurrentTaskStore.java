package org.jboss.as.tasksJsf.service;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.jboss.as.tasksJsf.data.model.Task;
import org.jboss.as.tasksJsf.qualifier.CurrentTask;


@SuppressWarnings("serial")
@ConversationScoped
public class CurrentTaskStore implements Serializable {

    private Task currentTask;

    @Produces
    @CurrentTask
    @Named("currentTask")
    public Task get() {
        return currentTask;
    }

    public void set(Task currentTask) {
        this.currentTask = currentTask;
    }

    public void unset() {
        this.currentTask = null;
    }
}
