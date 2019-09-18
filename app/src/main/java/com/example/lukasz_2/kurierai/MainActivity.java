package com.example.lukasz_2.kurierai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.lukasz_2.kurierai.Manager.Manager;
import com.example.lukasz_2.kurierai.Tools.DataBaseHelper;
import com.example.lukasz_2.kurierai.fragments.Fragment_Login;
import com.example.lukasz_2.kurierai.Interface.NavigationListener;


public class MainActivity extends AppCompatActivity implements NavigationListener {
    private RequestQueue que;
    private int x=0;
    private static Manager manager;
    private static SQLiteDatabase sqLiteDatabase;
            private static DataBaseHelper dataBaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        que = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main);
        changeFragment(Fragment_Login.newInstance(), false);
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        manager = Manager.getInstance();
        manager.SetSQL(sqLiteDatabase,dataBaseHelper);
        manager.deleteSQL();
        manager.onCreative();
        manager.setQue(que);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    public void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.root, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.toString());
        }
        fragmentTransaction.commit();
    }



    public static Manager getManger() {
        if (!manager.isEmpty())
            return manager;
        else
            return Manager.getInstance();
    }

    @Override
    public void onBackPressed(){
        System.out.println("cofnięcie!");
        if(x==0){

        }
        else{
            System.out.println("zamknięcie!");
            System.exit(0);
            Log.d("AdminShop","onBackPressed Called");
        }
    }

}
