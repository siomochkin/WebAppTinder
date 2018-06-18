package xyz.siomochkin.dao;

import xyz.siomochkin.model.User;

import java.util.HashMap;

public class UsersList {
    int uniqueId = 0;

    int getUniqueId()
    {
        return uniqueId++;
    }

    HashMap<Integer, User> usersList = new HashMap<>();

    public HashMap<Integer, User> getListUser() {

        usersList.put(1, new User("Evelyn", "http://img.izismile.com/img/img6/20130304/640/naturally_beautiful_girls_640_12.jpg", getUniqueId()));
        usersList.put(2, new User("Emily", "http://img.izismile.com/img/img6/20130304/640/naturally_beautiful_girls_640_14.jpg", getUniqueId()));
        usersList.put(3, new User("Sofia", "http://img.izismile.com/img/img6/20130304/640/naturally_beautiful_girls_640_30.jpg", getUniqueId()));
        usersList.put(4, new User("Madison", "http://img.izismile.com/img/img6/20130304/640/naturally_beautiful_girls_640_08.jpg", getUniqueId()));
        usersList.put(5, new User("Mia", "http://img.izismile.com/img/img6/20130304/640/naturally_beautiful_girls_640_01.jpg", getUniqueId()));

        return usersList;
    }




}
