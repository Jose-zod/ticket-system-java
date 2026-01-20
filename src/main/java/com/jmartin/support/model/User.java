package com.jmartin.support.model;

import com.jmartin.support.model.UserType;

public class User {
    private int  id;
    private String name;
    private String email;
    private UserType type;



public User (int id,String name,String email,UserType type) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.type = type;

}
public UserType getType() {
    return type;
}
public String getName() {
    return name;
}
}


