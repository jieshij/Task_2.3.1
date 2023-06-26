package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }


    @Override
    public void add(User user) {
        entityManager.merge(user);
    }


    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void updateUser(int id, User updateUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setFirstName(updateUser.getFirstName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setEmail(updateUser.getEmail());

    }


    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
