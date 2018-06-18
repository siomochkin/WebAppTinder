package xyz.siomochkin.dao;

import xyz.siomochkin.model.User;

import java.util.HashMap;

public class UserDAO {

    public HashMap<Integer, User> base = new UsersList().getListUser();
    public int id = base.size();

    public User get (Integer id){
        return base.get(id);
    }

}
