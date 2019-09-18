package com.example.lukasz_2.kurierai.PerformanceInterface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukasz_2.kurierai.base.BaseFragment;


public class ElementInterface {
    private TextView Name;
    private TextView Decryption;
    private ImageView Imageview;
    private BaseFragment baseFragment;

    public ElementInterface(BaseFragment layout) {
        baseFragment = layout;
        Name = new TextView(baseFragment.getContext());
        Decryption = new TextView(baseFragment.getContext());
        Imageview = new ImageView(baseFragment.getContext());
    }
    public static class BuliderElementInterface {
        private TextView Name;
        private TextView Decryption;
        private ImageView Imageview;
        private BaseFragment baseFragment;

        public BuliderElementInterface(BaseFragment layout){
            baseFragment = layout;
            Name = new TextView(baseFragment.getContext());
            Decryption = new TextView(baseFragment.getContext());
            Imageview = new ImageView(baseFragment.getContext());
        }
        public void setName(String name) {
            Name.setText(name);
        }

        public void setDecryption(String description) {
            Decryption.setText(description);
        }

        public void setImage(byte[] bytes) {
            Bitmap map = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            Imageview.setImageBitmap(map);
        }

        public ElementInterface bulid() {
            ElementInterface element = new ElementInterface(baseFragment);
            element.Name = Name;
            element.Decryption = Decryption;
            element.Imageview = Imageview;
            return element;
        }
    }
}
