package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Dao implements DaoInt {
    private List<User> users = new ArrayList<>();

    public Dao() {
        User user = new User();
        user.setId(1);
        user.setName("qq");
        user.setAge(5);
        User user2 = new User();
        user2.setId(2);
        user2.setName("ww");
        user2.setAge(2);
        users.add(user);
        users.add(user2);

    }

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(int id) {
//        for (User user : users)
//            if (id == user.getId()) {
//                return users.get(id);
//            }
//        {
//
//        }
//        return null;
        //  }
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}