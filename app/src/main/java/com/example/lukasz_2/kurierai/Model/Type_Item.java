package com.example.lukasz_2.kurierai.Model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Type_Item {
    @SerializedName("Id")
    private Integer id;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Image")
    private byte[] bitmap;

    public Type_Item(Integer id, String name, String description, byte[] bitmap) {
        this.id = id;
        Name = name;
        Description = description;
        this.bitmap = bitmap;
    }
    public static class BuliderType_Item{
        private Integer id;
        private String Name;
        private String Description;
        private byte[] bitmap;

        public BuliderType_Item() {
            id = new Integer(0);
            Name = "";
            Description = "";
            bitmap = new byte[1];
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public byte[] getBitmap() {
            return bitmap;
        }

        public void setType(Type_Item type){
            id = type.id;
            Name = type.Name;
            Description = type.Description;
            bitmap = type.bitmap;
        }

        public void setBitmap(byte[] bitmap) {
            this.bitmap = bitmap;
        }
        public Type_Item bulid(){
            return new Type_Item(getId(),getName(),getDescription(),getBitmap());
        }
    }
}

