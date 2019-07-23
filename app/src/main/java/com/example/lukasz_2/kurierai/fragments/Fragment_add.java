package com.example.lukasz_2.kurierai.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;

public class Fragment_add extends BaseFragment implements View.OnClickListener {

    private static final int RESULT_OK = 1;
    private ImageButton News;
    private ImageButton Message;
    private ImageButton Add;
    private ImageButton Option;
    private ImageButton Camera;
    private ImageView imageView;

    public static Fragment_add newInstance() {
        return new Fragment_add();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);

        findViews(rootView);
        setListeners();

        return rootView;
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        News = view.findViewById(R.id.ib_news_main_add);
        Message = view.findViewById(R.id.ib_massage_main_add);
        Add = view.findViewById(R.id.ib_add_main_add);
        Option = view.findViewById(R.id.ib_option_main_add);
        Camera = view.findViewById(R.id.ib_camera_menu_add);
        imageView = view.findViewById(R.id.iv_image_menu_add);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        News.setOnClickListener(this);
        Message.setOnClickListener(this);
        Add.setOnClickListener(this);
        Option.setOnClickListener(this);
        Camera.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        System.out.println("Klikniecie menu!");
        switch (v.getId()) {
            case R.id.ib_add_main_add:
                System.out.println("Add!");
                getNavigationListener().changeFragment(Fragment_add.newInstance(), true);
                break;
            case R.id.ib_massage_main_add:
                System.out.println("Message!");
                getNavigationListener().changeFragment(Fragment_message.newInstance(), true);
                break;
            case R.id.ib_news_main_add:
                System.out.println("News!");
                getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                break;
            case R.id.ib_option_main_add:
                System.out.println("Option!");
                getNavigationListener().changeFragment(Fragment_option.newInstance(), true);
                break;
            case R.id.ib_camera_menu_add:
                System.out.println("Camera!");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(intent, 1);
                break;
        }
    }

}
