package com.example.lukasz_2.kurierai.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;

public class Fragment_message extends BaseFragment implements View.OnClickListener {

    private ImageButton News;
    private ImageButton Message;
    private ImageButton Add;
    private ImageButton Option;

    public static Fragment_message newInstance() {
        return new Fragment_message();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);

        findViews(rootView);
        setListeners();

        return rootView;
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        News = view.findViewById(R.id.ib_news_main_message);
        Message = view.findViewById(R.id.ib_massage_main_message);
        Add = view.findViewById(R.id.ib_add_main_message);
        Option = view.findViewById(R.id.ib_option_main_message);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        News.setOnClickListener(this);
        Message.setOnClickListener(this);
        Add.setOnClickListener(this);
        Option.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        System.out.println("Klikniecie menu!");
        switch (v.getId()) {
            case R.id.ib_add_main_message:
                System.out.println("Add!");
                getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
                break;
            case R.id.ib_massage_main_message:
                System.out.println("Message!");
                getNavigationListener().changeFragment(Fragment_message.newInstance(), true);
                break;
            case R.id.ib_news_main_message:
                System.out.println("News!");
                getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                break;
            case R.id.ib_option_main_message:
                System.out.println("Option!");
                getNavigationListener().changeFragment(Fragment_option.newInstance(), true);
                break;
        }
    }

}
