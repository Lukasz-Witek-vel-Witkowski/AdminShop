package com.example.lukasz_2.kurierai.Model;

public class RegisterModerator {
   private String Login;
   private String Password;
   private String FirstName;
   private String SecendName;

    public RegisterModerator(String login, String password, String firstName, String secendName) {
        Login = login;
        Password = password;
        FirstName = firstName;
        SecendName = secendName;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecendName() {
        return SecendName;
    }
}
