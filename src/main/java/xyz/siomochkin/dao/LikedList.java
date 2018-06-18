package xyz.siomochkin.dao;

import xyz.siomochkin.model.Liked;

import java.util.HashMap;

public class LikedList {

    HashMap<Integer, Liked> likedList = new HashMap<>();

       public HashMap<Integer, Liked> getLikedList(){

           return likedList;
       }

}
