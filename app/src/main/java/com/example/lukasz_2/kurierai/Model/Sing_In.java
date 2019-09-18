package com.example.lukasz_2.kurierai.Model;

public class Sing_In {
   private String Login;
   private String Password;

    public Sing_In(String login, String password) {
        Login = login;
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

}
