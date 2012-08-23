package com.forum.domain;

public class Question {
    private String title;
    private String createdAt;
    private String description;
    private int userId;

    public Question(String title,String description,int userId,String createdAt){
        this.title=title;
        this.userId=userId;
        this.createdAt = createdAt;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }


    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }
}
