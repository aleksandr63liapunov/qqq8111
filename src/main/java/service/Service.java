package service;

import dao.DaoInt;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository

public class Service implements Serviceint {

    private final DaoInt daoInt ;
@Autowired
    public Service(DaoInt daoInt) {
        this.daoInt=daoInt;
    }

    @Transactional
    @Override
    public void save(User user) {
//        List<User> users = null;
//        if (user != null) {
//            users = daoInt.getAll();
//        }
//        if (!users.isEmpty()) {
//            User lastUser = users.get(users.size() - 1);
//            user.setId(lastUser.getId() + 1);
//            daoInt.save(user);
//        }
       daoInt.save(user);
    }


    @Override
    public void delete(int id) {

            daoInt.delete(id);


    }

    @Transactional
    @Override
    public List<User> getAll() {
        return daoInt.getAll();
    }

    @Transactional
    @Override
    public User getById(int id) {
        if (id != 0) {
            return daoInt.getById(id);
        }
        return null;

    }

    @Transactional
    @Override
    public void update(int id, User userNew) {
        if (id != 0) {
            daoInt.update(id, userNew);
        }
    }

}
