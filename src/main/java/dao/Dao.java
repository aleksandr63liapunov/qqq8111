package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Dao implements DaoInt {
//    private List<User> users = new ArrayList<>();
//    private static int count;
//
//    public Dao() {
//        User user = new User();
//        user.setId(++count);
//        user.setName("qq");
//        user.setAge(5);
//        User user2 = new User();
//        user2.setId(++count);
//        user2.setName("ww");
//        user2.setAge(2);
//        users.add(user);
//        users.add(user2);
//
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
//        entityManager.remove(user);
    }

    @Transactional
    @Override
    public List<User> getAll() {

        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Transactional
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
//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void update(int id, User userNew) {
//       User updateUser=getById( id);
//        updateUser.setId(userNew.getId());
//        updateUser.setName(userNew.getName());
//        updateUser.setAge(userNew.getAge());
        userNew.setId(id);
        entityManager.merge(userNew);
    }
}