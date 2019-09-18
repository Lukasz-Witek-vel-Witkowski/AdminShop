package com.example.lukasz_2.kurierai.Model;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Login_register {
    @SerializedName("status")
    private String Status;
    @SerializedName("Error")
    private String[] Error;
   /* public Login_register(String status, String[] error){
        Status = status;
        Error = error;
    }*/

    public String getStatus() {
        return Status;
    }

    public String[] getError() {
        return Error;
    }

    @Override
    public String toString() {
        return "Login_register{" +
                "Status='" + Status + '\'' +
                ", Error=" + Arrays.toString(Error) +
                '}';
    }
}
