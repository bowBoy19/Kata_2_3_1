package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
    @Override
    @Transactional
    public List<User> listUsers() {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }
}
