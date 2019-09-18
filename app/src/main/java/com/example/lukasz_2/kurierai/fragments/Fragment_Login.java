package com.example.lukasz_2.kurierai.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.lukasz_2.kurierai.Model.Login_register;
import com.example.lukasz_2.kurierai.Model.Sing_In;
import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.Tools.Call;
import com.example.lukasz_2.kurierai.base.BaseFragment;
import com.google.gson.Gson;


public class Fragment_Login extends BaseFragment implements View.OnClickListener {

    private AppCompatButton sendButton;
    private Button Register;
    private EditText Password;
    private EditText Login;

    public static Fragment_Login newInstance() {
        return new Fragment_Login();
    }


    @Override
    public void SuccesfullExeciute(String response) {
        super.SuccesfullExeciute(response);
        String Error;
        System.out.println(response.toString());
        Gson gson = new Gson();
        Login_register login_register;
        System.out.println(response);
        login_register = gson.fromJson(response, Login_register.class );
        if(login_register!=null) {
            System.out.println("Login_register = " + login_register.toString());
            if (login_register.getStatus().endsWith("Accept")) {
                BaseFragment.getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                Toast.makeText(getContext(), "Udało się zalogować", Toast.LENGTH_SHORT).show();
                System.out.println("Udało się zalogować");
            } else if (login_register.getStatus().endsWith("Rejection")) {
                Error = login_register.getError()[0];
                if (Error.equals("Login/Password")) {
                    Toast.makeText(getContext(), "Login lub hasło jest niepoprawne", Toast.LENGTH_SHORT).show();
                    System.out.println("Nie udało się zalogować");
                }
            }
        }
        else{
            Toast.makeText(getContext(), "Probelm z łącznością z serverem", Toast.LENGTH_SHORT).show();
            System.out.println("Nie udało się zalogować");
        }
    }


    @Override
    public void ErrorExeciute(VolleyError error) {
        super.ErrorExeciute(error);
        error.printStackTrace();
    }

    @Override
    public void onClick(View view) {
        System.out.println("kliknięcie");
        switch (view.getId()) {
            case R.id.fragment_login_Sing_In:
                if (!isEmpty()) {
                    Execiute();
                } else {
                    Toast.makeText(getContext(), "Nie podano danych do logowania", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.fragment_login_Register:
                BaseFragment.getNavigationListener().changeFragment(Fragment_register.newInstance(), true);
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
        Register = view.findViewById(R.id.fragment_login_Register);
        Password = view.findViewById(R.id.fragment_login_Password);
        Login = view.findViewById(R.id.fragment_login_Login);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        sendButton.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    private boolean isEmpty(){
        if(Login.getText().toString().isEmpty()&&Password.getText().toString().isEmpty())
            return true;
        return false;
    }
    @Override
    public void Execiute(){
        super.Execiute();
        Call.Builder builder = new Call.Builder();
        builder.setSing_in(new Sing_In(Login.getText().toString(), Password.getText().toString()));
        builder.setSend(Call.SEND.Login);
        builder.bulid().execiute(Request.Method.GET,this);
    }
}

