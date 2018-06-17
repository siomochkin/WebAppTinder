package xyz.siomochkin.dao;

import xyz.siomochkin.model.User;
import xyz.siomochkin.DB.UsersList;

import java.util.HashMap;

public class UserDAO {

    public HashMap<Integer, User> base = new UsersList().getListUser();
    public int id = base.size();

    public void save(User user) {
        base.put(++id, user);
    }

    public User get (Integer id){
        return base.get(id);
    }

    public void update(Integer id, User newUser){
        base.replace(id, newUser);
    }

    public void delete(Integer id){
        base.remove(id);
    }
}
