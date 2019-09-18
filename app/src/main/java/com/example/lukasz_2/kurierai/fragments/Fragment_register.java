package com.example.lukasz_2.kurierai.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.lukasz_2.kurierai.Model.Login_register;
import com.example.lukasz_2.kurierai.Model.RegisterModerator;
import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.Tools.Call;
import com.example.lukasz_2.kurierai.base.BaseFragment;
import com.google.gson.Gson;

public class Fragment_register extends BaseFragment implements View.OnClickListener {
    EditText FirstName;
    EditText LastName;
    EditText Login;
    EditText Password;
    Button Register;
    Button Cancel;
    String URL;
    public static Fragment_register newInstance() {
        return new Fragment_register();
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        System.out.println("kliknięcie");
        switch (v.getId()) {
            case R.id.but_menu_register_register:
                if (!isEmpty()) {
                    Execiute();
                } else {
                    Toast.makeText(getContext(),
                            "Nie podano danych do logowania",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.but_menu_register_cancel:
                BaseFragment.getNavigationListener().changeFragment(Fragment_Login.newInstance(), true);
                break;
        }
    }
    private boolean isEmpty(){
        if(FirstName.getText().toString().isEmpty()&&
                LastName.getText().toString().isEmpty()&&
                Login.getText().toString().isEmpty()&&
                Password.getText().toString().isEmpty())
        return true;
        return false;
    }

    @Override
    public void SuccesfullExeciute(String response) {
        super.SuccesfullExeciute(response);
        String status = "";
        String[] Error;
        System.out.println(URL);
        System.out.println(response.toString());
        Gson gson = new Gson();
        Login_register login_register;
        System.out.println(response);
        String dataError = "";
        login_register = gson.fromJson(response, Login_register.class );
        if(login_register!=null) {
            System.out.println("Login_register = " + login_register.toString());
            if (login_register.getStatus().endsWith("Accept")) {
                Toast.makeText(getContext(), "Udało się zarejestrować", Toast.LENGTH_SHORT).show();
                System.out.println("Udało się zalogować");
                BaseFragment.getNavigationListener().changeFragment(Fragment_Login.newInstance(), true);
            } else if (login_register.getStatus().endsWith("Rejection")) {
                Error = login_register.getError();
                for (int i = 0; i < Error.length; i++) {
                    if (Error[i].equals("NotLogin")) {
                        dataError +="Podany Login jest przypisany do innego użytkownika\n";
                       // System.out.println("Nie udało się zalogować");
                    } else if (Error[i].equals("Error_FirstName")) {
                        dataError += "Podane imie jest niepoprawne\n";
                       // System.out.println("Nie udało się zalogować");
                    } else if (Error[i].equals("Error_LastName")) {
                        dataError += "Podane nazwisko jest niepoprawne\n";
                       // System.out.println("Nie udało się zalogować");
                    }
                    if (Error[i].equals("Error_Password")) {
                        dataError += "Podane hasło jest niepoprawne\n";
                       // System.out.println("Nie udało się zalogować");
                    }
                    if (Error[i].equals("Error_Login")) {
                        dataError += "Podany Login jest niepoprawny\n";
                        //System.out.println("Nie udało się zalogować");
                    }
                }
                Toast.makeText(getContext(), dataError, Toast.LENGTH_SHORT).show();
                System.out.println("Nie udało się zalogować");
            }
        }
        else{
            Toast.makeText(getContext(), "Problem z połączeniem z serverem", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void ErrorExeciute(VolleyError error) {
        super.ErrorExeciute(error);
        error.printStackTrace();
    }

    @Override
    public void Execiute() {
        super.Execiute();
        Call.Builder builder = new Call.Builder();
        builder.setSend(Call.SEND.Register);
        builder.setRegisterModerator(
                new RegisterModerator(
                    Login.getText().toString(),
                    Password.getText().toString(),
                    FirstName.getText().toString(),
                    LastName.getText().toString())
        );
        builder.bulid().execiute(Request.Method.GET,this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        findViews(rootView);
        setListeners();

        return rootView;
    }
    private void findViews(View view) {
        System.out.println("przetwarzanie danych");
        FirstName = view.findViewById(R.id.Et_menu_register_Name);
        LastName = view.findViewById(R.id.Et_menu_register_LastName);
        Login = view.findViewById(R.id.Et_menu_register_Login);
        Password = view.findViewById(R.id.Et_menu_register_Password);
        Register = view.findViewById(R.id.but_menu_register_register);
        Cancel = view.findViewById(R.id.but_menu_register_cancel);
    }
    private void setListeners() {
        System.out.println("SetListeners");
        Register.setOnClickListener(this);
        Cancel.setOnClickListener(this);
    }
}
