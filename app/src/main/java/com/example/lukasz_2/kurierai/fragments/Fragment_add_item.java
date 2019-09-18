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

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.lukasz_2.kurierai.MainActivity;
import com.example.lukasz_2.kurierai.Manager.Manager;
import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.Sing_In;
import com.example.lukasz_2.kurierai.R;
import com.example.lukasz_2.kurierai.Tools.Call;
import com.example.lukasz_2.kurierai.Tools.JSON;
import com.example.lukasz_2.kurierai.base.BaseFragment;
import java.io.ByteArrayOutputStream;


public class Fragment_add_item extends BaseFragment implements View.OnClickListener {

	private static final int RESULT_OK = 1;
	private ImageButton News;
	private ImageButton Message;
	private ImageButton Add;
	private ImageButton Option;
	private ImageButton Camera;
	private ImageView imageView;
	private EditText Name;
	private EditText Description;
	private EditText Cost;
	private Button Send;
	private Button Save;
	private Button Load;
	private Button Canel;
	private Manager MD;
	private byte[] Image;
	private String URL;

	public static Fragment_add_item newInstance() {
		return new Fragment_add_item();
	}

	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_add, container, false);

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
		News = view.findViewById(R.id.ib_news_main_add);
		Message = view.findViewById(R.id.ib_massage_main_add);
		Add = view.findViewById(R.id.ib_add_main_add);
		Option = view.findViewById(R.id.ib_option_main_add);
		Camera = view.findViewById(R.id.ib_camera_menu_add);
		imageView = view.findViewById(R.id.iv_image_menu_add);
		Send = view.findViewById(R.id.menu_add_butt_send);
		Save = view.findViewById(R.id.menu_add_butt_save);
		Load = view.findViewById(R.id.menu_add_load);
		Name = view.findViewById(R.id.et_menu_add_name);
		Description = view.findViewById(R.id.et_menu_add_Description);
		Cost = view.findViewById(R.id.et_menu_add_cost);
		Canel = view.findViewById(R.id.menu_add_butt_canel);
	}

	private void setListeners() {
		System.out.println("SetListeners");
		News.setOnClickListener(this);
		Message.setOnClickListener(this);
		Add.setOnClickListener(this);
		Option.setOnClickListener(this);
		Camera.setOnClickListener(this);
		Send.setOnClickListener(this);
		Save.setOnClickListener(this);
		Load.setOnClickListener(this);
		Canel.setOnClickListener(this);
	}


	@RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			Bundle extras = data.getExtras();
			Bitmap Bit = (Bitmap) extras.get("data");
			imageView.setImageBitmap(Bit);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Bit.compress(Bitmap.CompressFormat.PNG, 100, baos);
			Image = baos.toByteArray();
			int i =0;
		}
	}

	@Override
	public void SuccesfullExeciute(String response) {
		super.SuccesfullExeciute(response);
		System.out.println(response);
	}

	@Override
	public void ErrorExeciute(VolleyError error) {
		super.ErrorExeciute(error);
	}

	@Override
	public void Execiute() {
		super.Execiute();
		Call.Builder builder = new Call.Builder();
		builder.setSend(Call.SEND.Product);
		builder.setName(Name.getText().toString());
		builder.setDescryption(Description.getText().toString());
		builder.setCost(Cost.getText().toString());
		builder.setBat(Image);
		builder.setType("0"); //dla potrzeby
		builder.generatePost_Item();
		builder.bulid().execiute(Request.Method.POST,this);
	}

	private void addPost(boolean what) {
		if (String.valueOf(Name.getText()).isEmpty()) {
			Toast.makeText(getContext(), "Aby dodać produkt należy dodać nazwę produktu", Toast.LENGTH_SHORT).show();
		} else if (!String.valueOf(Name.getText()).isEmpty()) {
				Post_Item.BilderPost_Item bild = new Post_Item.BilderPost_Item();
				bild.setID(1); //managerID do implementacji
				bild.setNameItem(String.valueOf(Name.getText()));
				bild.setDescriptionItem(String.valueOf(Description.getText()));
				bild.setCost(0.0);
				bild.setImageView(Image);
				MD.setPost_Image(bild.build());
				MD.Post_save_to_SQL();
				System.out.println(Name.getText() + " + " + Description.getText() + " + " + 0.0);
				if(what){
					Execiute();
				}
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
				getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
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
			case R.id.menu_add_butt_save:
				addPost(false);
				getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
				break;
			case R.id.menu_add_butt_send:
				addPost(true);
				getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);
				break;
			case R.id.menu_add_load:

				break;
			case R.id.menu_add_butt_canel:
				System.out.println("canel");
				getNavigationListener().changeFragment(Fragment_add_choice.newInstance(), true);

				break;
		}
	}


}
