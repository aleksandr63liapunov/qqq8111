package service;

import dao.Dao;
import dao.DaoInt;
import model.User;

import java.util.List;

public class Service implements Serviceint {
    private DaoInt daoInt = new Dao();

    @Override
    public void save(User user) {
        List<User> users = null;
        if (user != null) {
            users = daoInt.getAll();
        }
        if (!users.isEmpty()) {
            User lastUser = users.get(users.size() - 1);
            user.setId(lastUser.getId() + 1);
            daoInt.save(user);
        }

    }

    @Override
    public void delete(User user) {
        if (user != null) {
            daoInt.delete(user);
        }

    }

    @Override
    public List<User> getAll() {
        return daoInt.getAll();
    }

    @Override
    public User getById(int id) {

        return daoInt.getById(id);


    }

}
