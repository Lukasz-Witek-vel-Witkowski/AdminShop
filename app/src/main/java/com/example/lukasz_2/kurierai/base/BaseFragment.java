package com.example.lukasz_2.kurierai.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.lukasz_2.kurierai.navigation.NavigationListener;

public class BaseFragment extends Fragment {

    NavigationListener navigationListener;

    public NavigationListener getNavigationListener() {
        return navigationListener;
    }
    @Override
    public void onDetach(){
        super.onDetach();
        navigationListener = null;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof NavigationListener){
            navigationListener = (NavigationListener) context;
        }
    }
}
