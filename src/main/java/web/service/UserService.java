package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();
    void add(User user);
    public User show(int id);
    public void update(int id, User updatetUser);
    public void delete(int id);
}
