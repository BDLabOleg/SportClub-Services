package com.sclubs.sportclub.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public final class Ident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userId;
    private String password;
    private String email;

    public Ident(){
    }

    public Ident(String userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


