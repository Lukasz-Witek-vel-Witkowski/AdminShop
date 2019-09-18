package com.example.lukasz_2.kurierai.Model;

import android.graphics.Bitmap;

public class Post_Item {
    protected int ID;
    protected String NameItem;
    protected String DescriptionItem;
    protected byte[] ImageItem;
    protected Double Cost;
    protected Integer Type;

    protected Post_Item(int ID, String nameItem, String descriptionItem, byte[] imageItem, Double cost, Integer type) {
        this.ID = ID;
        NameItem = nameItem;
        DescriptionItem = descriptionItem;
        ImageItem = imageItem;
        Cost = cost;
        Type = type;
    }

    public String getNameItem() {
        return NameItem;
    }

    public String getDescriptionItem() {
        return DescriptionItem;
    }

    public Double getCost() {
        return Cost;
    }

    public Integer getType() {
        return Type;
    }

    protected Post_Item(Post_Item post_item) {
        ID = post_item.ID;
        NameItem = post_item.NameItem;
        DescriptionItem = post_item.NameItem;
        Cost = post_item.Cost;
        ImageItem = post_item.ImageItem;
        Type = post_item.Type;
    }

    public int getID() {
        return ID;
    }

    public static class BilderPost_Item {
        private int ID;
        private String NameItem;
        private String DescriptionItem;
        private byte[] ImageItem;
        private Double Cost;
        private Integer Type;

        public Integer getType() {
            return Type;
        }

        public void setType(Integer type) {
            Type = type;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNameItem() {
            return NameItem;
        }

        public void setNameItem(String nameItem) {
            NameItem = nameItem;
        }

        public String getDescriptionItem() {
            return DescriptionItem;
        }

        public void setDescriptionItem(String descriptionItem) {
            DescriptionItem = descriptionItem;
        }

        public byte[] getImageItemVuew() {
            return ImageItem;
        }


        public void setImageView(byte[] imageView) {
            ImageItem = imageView;
        }

        public Double getCost() {
            return Cost;
        }

        public void setCost(Double cost) {
            Cost = cost;
        }

        public Post_Item build() {
            return new Post_Item(getID(),
                    getNameItem(),
                    getDescriptionItem(),
                    getImageItemVuew(),
                    getCost(),
                    getType());
        }
    }
}
