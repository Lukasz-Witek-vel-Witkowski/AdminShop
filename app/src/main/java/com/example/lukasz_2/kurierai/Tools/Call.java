package com.example.lukasz_2.kurierai.Tools;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.lukasz_2.kurierai.Manager.Manager;
import com.example.lukasz_2.kurierai.Manager.ManagerID;
import com.example.lukasz_2.kurierai.Model.Login_register;
import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.RegisterModerator;
import com.example.lukasz_2.kurierai.Model.RegisterUser;
import com.example.lukasz_2.kurierai.Model.Sing_In;
import com.example.lukasz_2.kurierai.Model.Type_Item;
import com.example.lukasz_2.kurierai.base.BaseFragment;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Call {
    private JSON json;
    private TranslatorfromImage translatorfromImage;
    private Sing_In sing_in;
    private RegisterModerator registerModerator;
    private RegisterUser registerUser;
    private Type_Item type_item;
    private Post_Item post_item;
    private String[] URLS;
    private int SizeImage;
    public enum SEND{
        Login,
        Register,
        Product,
        Type
    }
    private String URL;
    public Call(TranslatorfromImage translatorfromImage, Sing_In sing_in, RegisterModerator registerModerator, RegisterUser registerUser,Type_Item type_item, Post_Item post_item, SEND s){
        json = new JSON();
        this.translatorfromImage = translatorfromImage;
        this.sing_in = sing_in;
        this.registerModerator = registerModerator;
        this.registerUser = registerUser;
        this.type_item = type_item;
        this.post_item = post_item;
        switch (s){
            case Login:
                json.GetLogin(sing_in.getLogin(), sing_in.getPassword());
                URL = json.getUrl();
                break;
            case Register:
                json.GetRegister(registerModerator.getFirstName(),
                        registerModerator.getSecendName(),
                        registerModerator.getLogin(),
                        registerModerator.getPassword()
                );
                URL = json.getUrl();
                break;
            case Product:
                SizeImage = translatorfromImage.getsize();
                URLS = new String[SizeImage];
                json.getProduct(
                        JSON.OPERATION.Add,
                        String.valueOf(post_item.getID()),
                        post_item.getNameItem(),
                        post_item.getDescriptionItem(),
                        String.valueOf(post_item.getCost()),
                        String.valueOf(post_item.getType()),
                        String.valueOf(SizeImage)
                );
                URL = json.getUrl();
                for(int i=0; i<translatorfromImage.getsize(); i++ ){
                    if(translatorfromImage.isNext()) {
                        json.getCellImageURL(translatorfromImage.getposition(), translatorfromImage.Next());
                        URLS[i] = json.getUrl();
                    }
                }
                break;
        }

    }
    public void execiute(final int method, final BaseFragment baseFragment){
        System.out.println("Method = "+method);
        System.out.println("URL = "+ URL);
      final JsonObjectRequest request = new JsonObjectRequest(method,URL, new JSONObject(),
               new Response.Listener<JSONObject>() {
                    @Override
                   public void onResponse(JSONObject response) {
                       baseFragment.SuccesfullExeciute(response.toString());
                       if(URLS != null){
                           final Gson gson = new Gson();
                           final Login_register[] login_register = new Login_register[1];
                           login_register[0] = gson.fromJson(response.toString(), Login_register.class );
                           if(login_register[0] !=null) {
                               System.out.println("Login_register = " + login_register[0].toString());
                               if (login_register[0].getStatus().endsWith("Accept")) {
                                    for(int i =0; i<SizeImage; i++){
                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        final int finalI = i;
                                        JsonObjectRequest Request = new JsonObjectRequest(method, URLS[i], new JSONObject(), new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject response) {
                                                login_register[0] = gson.fromJson(response.toString(), Login_register.class );
                                                if(login_register[0] !=null) {
                                                    System.out.println("Login_register = " + login_register[0].toString());
                                                    if (login_register[0].getStatus().endsWith("Accept")) {
                                                        Toast.makeText(baseFragment.getContext(), "Wysyłanie = "+String.valueOf(SizeImage)+" / "+String.valueOf(finalI)+"", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                else{
                                                    Toast.makeText(baseFragment.getContext(), "Probelm z łącznością z serverem", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }, new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                error.printStackTrace();
                                            }
                                        });
                                    }
                               }
                           }
                           else{
                               Toast.makeText(baseFragment.getContext(), "Probelm z łącznością z serverem", Toast.LENGTH_SHORT).show();
                           }
                       }
                   }
               }, new Response.ErrorListener() {
             @Override
           public void onErrorResponse(VolleyError error) {
               baseFragment.ErrorExeciute(error);
           }
       });
        Manager.getQUE().add(request);
    }


    public static class Builder {
       private byte[] bat;
       private Sing_In sing_in;
       private RegisterUser registerUser;
       private RegisterModerator registerModerator;
       private SEND send;
       private String Name;
       private String Descryption;
       private String Cost;
       private String Type;
       private Post_Item post_item;
       private Type_Item type_item;

        public void setName(String name) {
            Name = name;
        }
        public void generatePost_Item(){
            Post_Item.BilderPost_Item bulid = new Post_Item.BilderPost_Item();
            bulid.setCost(Double.valueOf(Cost));
            bulid.setType(Integer.valueOf(Type));
            bulid.setDescriptionItem(Descryption);
            bulid.setNameItem(Name);
            bulid.setImageView(bat);
            post_item = bulid.build();
        }
        public void generateType_Item(){
            Type_Item.BuliderType_Item bulid = new Type_Item.BuliderType_Item();
            bulid.setName(Name);
            bulid.setDescription(Descryption);
            bulid.setBitmap(bat);

            type_item = bulid.bulid();
        }
        public void setDescryption(String descryption) {
            Descryption = descryption;
        }

        public void setCost(String cost) {
            if(cost == "")
                cost = "0.0";
            Cost = cost;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getName() {
            return Name;
        }

        public String getDescryption() {
            return Descryption;
        }

        public String getCost() {
            return Cost;
        }

        public String getType() {
            return Type;
        }

        public Post_Item getPost_item() {
            return post_item;
        }

        public Type_Item getType_item() {
            return type_item;
        }

        public Builder(){}

        public SEND getSend() {
            return send;
        }

        public void setSend(SEND send) {
            this.send = send;
        }

        public void setBat(byte[] bat) {
            this.bat = bat;
        }
        public void setSing_in(Sing_In sing_in){
            this.sing_in = sing_in;
        }

        public Sing_In getSing_in() {
            return sing_in;
        }

        public RegisterUser getRegisterUser() {
            return registerUser;
        }

        public void setRegisterUser(RegisterUser registerUser) {
            this.registerUser = registerUser;
        }

        public RegisterModerator getRegisterModerator() {
            return registerModerator;
        }

        public void setRegisterModerator(RegisterModerator registerModerator) {
            this.registerModerator = registerModerator;
        }

        public byte[] getBat() {
            return bat;
        }
        public Call bulid(){
            return new Call(
                    new TranslatorfromImage(getBat()),
                    getSing_in(),
                    getRegisterModerator(),
                    getRegisterUser(),
                    getType_item(),
                    getPost_item(),
                    getSend());
        }
    }
}
