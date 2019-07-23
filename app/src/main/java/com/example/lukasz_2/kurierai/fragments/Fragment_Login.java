package com.example.lukasz_2.kurierai.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;

public class Fragment_Login extends BaseFragment implements View.OnClickListener {

    private AppCompatButton sendButton;
    private EditText Password;
    private EditText Login;

    public static Fragment_Login newInstance() {
        return new Fragment_Login();
    }

    @Override
    public void onClick(View view) {
        System.out.println("kliknięcie");
        switch (view.getId()) {
            case R.id.fragment_login_Sing_In:
                if (checkEditText()) {
                    getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                    Toast.makeText(getContext(), "Udało się zalogować", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Nie podano danych do logowania", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        findViews(rootView);
        setListeners();

        return rootView;
    }

    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        sendButton = view.findViewById(R.id.fragment_login_Sing_In);
        Password = view.findViewById(R.id.fragment_login_Password);
        Login = view.findViewById(R.id.fragment_login_Login);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        sendButton.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private boolean checkEditText() {
        String text = Password.getText().toString();
        return !text.isEmpty();
    }

}

