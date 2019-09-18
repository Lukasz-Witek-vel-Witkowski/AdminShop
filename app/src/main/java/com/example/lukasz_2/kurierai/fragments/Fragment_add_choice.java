package com.example.lukasz_2.kurierai.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;


public class Fragment_add_choice extends BaseFragment implements View.OnClickListener {

    private ImageButton News;
    private ImageButton Message;
    private ImageButton Add;
    private ImageButton Option;
    private Button Item;
    private Button Type;

    public static Fragment_add_choice newInstance() {
        return new Fragment_add_choice();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_choice, container, false);

        findViews(rootView);
        setListeners();

        return rootView;
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        News = view.findViewById(R.id.ib_news_main_add_choice);
        Message = view.findViewById(R.id.ib_massage_main_add_choice);
        Add = view.findViewById(R.id.ib_add_main_add_choice);
        Option = view.findViewById(R.id.ib_option_main_add_choice);
        Item = view.findViewById(R.id.but_iteam);
        Type = view.findViewById(R.id.but_type);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        News.setOnClickListener(this);
        Message.setOnClickListener(this);
        Add.setOnClickListener(this);
        Option.setOnClickListener(this);
        Item.setOnClickListener(this);
        Type.setOnClickListener(this);
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
            case R.id.ib_add_main_add_choice:
                System.out.println("Add!");
                getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
                break;
            case R.id.ib_massage_main_add_choice:
                System.out.println("Message!");
                getNavigationListener().changeFragment(Fragment_message.newInstance(), true);
                break;
            case R.id.ib_news_main_add_choice:
                System.out.println("News!");
                getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                break;
            case R.id.ib_option_main_add_choice:
                System.out.println("Option!");
                getNavigationListener().changeFragment(Fragment_option.newInstance(), true);
                break;
            case R.id.but_iteam:
                System.out.println("Item!");
                getNavigationListener().changeFragment(Fragment_add_item.newInstance(), true);
                break;
            case R.id.but_type:
                System.out.println("Type!");
                getNavigationListener().changeFragment(Fragment_add_type.newInstance(), true);
                break;
        }
    }

}
