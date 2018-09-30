package com.kitabxana_sb.tables;

public class User_info {

    private int iduser;
    private String full_name;
    private String email;
    private String password;

    public User_info() {
    }

    public User_info(int iduser, String full_name, String email, String password) {
        this.iduser = iduser;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

    public int getIduser() {
        return this.iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
