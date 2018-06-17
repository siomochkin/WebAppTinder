package xyz.siomochkin.model;

public class Liked {

    Integer likedId;
    Integer userId;
    Integer chatId;


    public void setLikedId(Integer likedId) {
        this.likedId = likedId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
}
