package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void delete(int id);
    void add(User user);
    public User getById( int id);
    void update(User user);
    List<User> listUsers();
}
