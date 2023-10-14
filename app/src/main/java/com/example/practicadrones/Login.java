package com.example.practicadrones;

public class Login {

    private final String username;
    private final String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean acceso(){
        return username.equals("admin") && password.equals("1234");
    };

}
