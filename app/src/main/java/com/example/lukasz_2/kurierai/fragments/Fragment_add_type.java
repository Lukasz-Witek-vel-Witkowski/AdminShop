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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lukasz_2.kurierai.MainActivity;
import com.example.lukasz_2.kurierai.Manager.Manager;
import com.example.lukasz_2.kurierai.Model.Type_Item;
import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.base.BaseFragment;


public class Fragment_add_type extends BaseFragment implements View.OnClickListener {

    private ImageButton News;
    private ImageButton Message;
    private ImageButton Add;
    private ImageButton Option;
    private ImageButton Camera;
    private Button AddType;
    private Button OptionType;
    private Button Canel;
    private EditText Name;
    private EditText Descryption;
    private ImageView imageView;
    private byte[] Image;
    private Manager MD;

    public static Fragment_add_type newInstance() {
        return new Fragment_add_type();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_type, container, false);

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
        News = view.findViewById(R.id.ib_news_main_add_type);
        Message = view.findViewById(R.id.ib_massage_main_add_type);
        Add = view.findViewById(R.id.ib_add_main_add_type);
        Option = view.findViewById(R.id.ib_option_main_add_type);
        AddType = view.findViewById(R.id.menu_add_type_Add);
        OptionType = view.findViewById(R.id.menu_add_type_Option);
        Canel = view.findViewById(R.id.menu_add_type_Canel);
        Name = view.findViewById(R.id.menu_add_type_name);
        imageView = view.findViewById(R.id.iv_image_menu_add);
        Camera = view.findViewById(R.id.ib_camera_menu_add);
        Descryption = view.findViewById(R.id.menu_add_type_description);
    }

    private void setListeners() {
        System.out.println("SetListeners");
        News.setOnClickListener(this);
        Message.setOnClickListener(this);
        Add.setOnClickListener(this);
        Option.setOnClickListener(this);
        AddType.setOnClickListener(this);
        OptionType.setOnClickListener(this);
        Canel.setOnClickListener(this);
        Name.setOnClickListener(this);
        imageView.setOnClickListener(this);
        Camera.setOnClickListener(this);
        Descryption.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bundle extras = data.getExtras();
            Bitmap Bit = (Bitmap) extras.get("data");
            imageView.setImageBitmap(Bit);
            Image = Bit.getNinePatchChunk();
        }
    }


    private void addType(){
       if(String.valueOf(Name.getText()).isEmpty()){
           Toast.makeText(getContext(), "Aby stworzyć nowy typ produktów należy dodać nazwę typu", Toast.LENGTH_SHORT).show();
       }
       else{
           Type_Item.BuliderType_Item bild = new Type_Item.BuliderType_Item();
           bild.setId(1); //managerID do implementacji
           bild.setName(String.valueOf(Name.getText()));
           bild.setDescription(String.valueOf(Descryption.getText()));
           bild.setBitmap(Image);
           MD.setType_Item(bild.bulid());
           MD.Type_save_to_SQL();
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
            case R.id.ib_add_main_add_type:
                System.out.println("Add!");
                getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
                break;
            case R.id.ib_massage_main_add_type:
                System.out.println("Message!");
                getNavigationListener().changeFragment(Fragment_message.newInstance(), true);
                break;
            case R.id.ib_news_main_add_type:
                System.out.println("News!");
                getNavigationListener().changeFragment(Fragment_news.newInstance(), true);
                break;
            case R.id.ib_option_main_add_type:
                System.out.println("Option!");
                getNavigationListener().changeFragment(Fragment_option.newInstance(), true);
                break;
            case R.id.menu_add_type_Add:
                System.out.println("Add!");
                addType();
                break;
            case R.id.menu_add_type_Option:
                System.out.println("Option!");

                break;
            case R.id.menu_add_type_Canel:
                System.out.println("Canel!");
                getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
                break;
            case R.id.ib_camera_menu_add:
                System.out.println("Camera!");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(intent, 1);
                break;
        }
    }

}
