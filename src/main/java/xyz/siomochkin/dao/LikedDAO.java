package xyz.siomochkin.dao;

import xyz.siomochkin.model.Liked;
import xyz.siomochkin.DB.LikedList;
import java.util.HashMap;

public class LikedDAO {

    public HashMap<Integer, Liked> base = new LikedList().getLikedList();
    public int id = base.size();

    public void save(Liked liked) {
        base.put(++id, liked);
    }

    public Liked get (Integer id){
        return base.get(id);
    }

}
