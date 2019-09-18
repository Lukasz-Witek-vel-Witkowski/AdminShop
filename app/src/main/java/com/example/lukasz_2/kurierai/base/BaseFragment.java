package com.example.lukasz_2.kurierai.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.android.volley.VolleyError;
import com.example.lukasz_2.kurierai.Interface.NavigationListener;
import com.example.lukasz_2.kurierai.Tools.Call;

import org.json.JSONObject;

public class BaseFragment extends Fragment {

    static NavigationListener navigationListener;

    public static NavigationListener getNavigationListener() {
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

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Wstecz");
    }
    protected String performanceImageIN(byte[] data){
        String Data = "";
        for(int i =0;i<data.length; i++ ){
            Data+=data[i];
            System.out.println( i +" - " +data[i]);
        }
        Data+='/';
        System.out.print(Data);
        return Data;
    }
    public void SuccesfullExeciute(String response){}

    public void ErrorExeciute(VolleyError error){}

    public void Execiute() {}

    }
