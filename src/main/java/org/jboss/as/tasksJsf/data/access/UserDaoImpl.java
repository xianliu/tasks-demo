package org.jboss.as.tasksJsf.data.access;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.as.tasksJsf.data.model.User;

@Stateful
public class UserDaoImpl implements UserDao {

    @Inject
    private EntityManager em;

    public User getForUsername(String username) {
        List<User> result = em.createQuery("select u from User u where u.username = ?", User.class).setParameter(1, username)
                .getResultList();

        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public void createUser(User user) {
        em.persist(user);
    }
}
