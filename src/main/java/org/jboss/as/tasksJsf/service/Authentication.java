package org.jboss.as.tasksJsf.service;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;

import org.jboss.as.tasksJsf.data.model.User;


@SuppressWarnings("serial")
@ConversationScoped
public class Authentication implements Serializable {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }
}
