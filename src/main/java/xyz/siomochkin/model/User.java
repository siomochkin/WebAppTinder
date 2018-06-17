package xyz.siomochkin.model;

public class User {
    private String name;
    private  String image;
    private Integer id;

    public User(String name, String image, Integer id) {
        this.name = name;
        this.image = image;
        this.id = id;
    }



    public String getName() {
        return name;
    }


    public String getImage() {
        return image;
    }


    public Integer getId() {
        return id;
    }

}
