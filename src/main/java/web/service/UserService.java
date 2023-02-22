package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    List<User> listUsers();
    User getById(int id);
}
