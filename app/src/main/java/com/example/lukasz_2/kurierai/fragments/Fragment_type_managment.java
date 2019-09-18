package com.example.lukasz_2.kurierai.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lukasz_2.kurierai.MainActivity;
import com.example.lukasz_2.kurierai.Manager.Manager;
import com.example.lukasz_2.kurierai.PerformanceInterface.FactoryInterafce;
import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;

public class Fragment_type_managment extends BaseFragment implements View.OnClickListener {

    private Manager MD;
    private static FactoryInterafce factory;
    public static Fragment_add_item newInstance() {return new Fragment_add_item();}

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);
        factory = new FactoryInterafce();
        setManagerData();
        findViews(rootView);
        setListeners();

        return rootView;
    }

    public void setManagerData() {
        MD = MainActivity.getManger();
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");

    }

    private void setListeners() {
        System.out.println("SetListeners");

    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        System.out.println("Klikniecie menu!");
        switch(v.getId()){

        }
    }
}
