package com.example.lukasz_2.kurierai.Model;

public class RegisterUser {
    private String Login;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Telephone;

    public RegisterUser(String login, String password, String firstName, String lastName, String email, String telephone) {
        Login = login;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Telephone = telephone;
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

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelephone() {
        return Telephone;
    }
}
