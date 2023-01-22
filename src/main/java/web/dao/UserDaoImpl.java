package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatetUser) {
        User userToUpdate = show(id);
        userToUpdate.setFirstName(updatetUser.getFirstName());
        userToUpdate.setLastName(updatetUser.getLastName());
        userToUpdate.setEmail(updatetUser.getEmail());
    }
    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}
