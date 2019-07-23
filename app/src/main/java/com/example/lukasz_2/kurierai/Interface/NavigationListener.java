package com.example.lukasz_2.kurierai.Interface;


import android.support.v4.app.Fragment;

public interface NavigationListener {
    void changeFragment(Fragment fragment, Boolean addToBackStack);
}
