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


public class Fragment_news extends BaseFragment implements View.OnClickListener {

    private ImageButton News;
    private ImageButton Message;
    private ImageButton Add;
    private ImageButton Option;

    public static Fragment_news newInstance() {
        return new Fragment_news();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        findViews(rootView);
        setListeners();

        return rootView;
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        News = view.findViewById(R.id.ib_news_main_news);
        Message = view.findViewById(R.id.ib_massage_main_news);
        Add = view.findViewById(R.id.ib_add_main_news);
        Option = view.findViewById(R.id.ib_option_main_news);
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
            case R.id.ib_add_main_news:
                System.out.println("Add!");
                getNavigationListener().changeFragment(Fragment_add.newInstance(), true);
                break;
            case R.id.ib_massage_main_news:
                System.out.println("Message!");
                getNavigationListener().changeFragment(Fragment_message.newInstance(), true);
                break;
            case R.id.ib_news_main_news:
                System.out.println("News!");
                getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                break;
            case R.id.ib_option_main_news:
                System.out.println("Option!");
                getNavigationListener().changeFragment(Fragment_option.newInstance(), true);
                break;
        }
    }

}
