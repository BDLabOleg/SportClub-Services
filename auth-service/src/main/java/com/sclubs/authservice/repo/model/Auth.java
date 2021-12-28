package com.sclubs.authservice.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public final class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String password;
    private long code;

    public Auth() {
    }

    public Auth(String email, String password, long code) {
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getCode() {
        return code;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
