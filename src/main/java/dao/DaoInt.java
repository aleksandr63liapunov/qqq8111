package dao;

import model.User;

import java.util.List;

public interface DaoInt {
    void save(User user);

    void delete(User user);

    List<User> getAll();

    User getById(int id);

    void update(int id, User userNew);
}
