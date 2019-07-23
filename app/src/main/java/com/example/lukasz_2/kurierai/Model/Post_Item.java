package com.example.lukasz_2.kurierai.Model;

import android.media.Image;

public class Post_Item {
    private int ID;
    private String NameItem;
    private String DescriptionItem;
    private Image ImageItem;
    private Double Cost;

    private Post_Item(int ID, String nameItem, String descriptionItem, Image imageItem, Double cost) {
        this.ID = ID;
        NameItem = nameItem;
        DescriptionItem = descriptionItem;
        ImageItem = imageItem;
        Cost = cost;
    }

    public int getID() {
        return ID;
    }

    public class BilderPost_Item {
        private int ID;
        private String NameItem;
        private String DescriptionItem;
        private Image ImageItem;
        private Double Cost;

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

        public Image getImageItem() {
            return ImageItem;
        }

        public void setImageItem(Image imageItem) {
            ImageItem = imageItem;
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
                    getImageItem(),
                    getCost());
        }
    }
}
