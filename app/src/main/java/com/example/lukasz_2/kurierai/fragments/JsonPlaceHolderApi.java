package com.example.lukasz_2.kurierai.fragments;

import com.example.lukasz_2.kurierai.Model.Login_register;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("")
    Call<Post> getPosts();
}
