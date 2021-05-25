package com.dailygit.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Pets")
public class PetModel {
    @Id
    public String id;

    private String name;

    private String race;

    private String type;

    private String content;

    private String userID;

    private Date timestamp = new Date();

    public PetModel(String name, String race, String type, String content, String userID) {
        this.name = name;
        this.race = race;
        this.type = type;
        this.content = content;
        this.userID = userID;
    }
    public PetModel(String userID) {
        this.userID = userID;
    }
    public PetModel() {
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getRace() {return race; }

    public String getType() {return type; }

    public String getName() {
        return name;
    }
    public String getUserID() {
        return userID;
    }
}
