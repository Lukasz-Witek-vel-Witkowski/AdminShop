package com.example.lukasz_2.kurierai.Manager;

import android.graphics.Bitmap;

import com.example.lukasz_2.kurierai.Interface.ManagerDataInterface;
import com.example.lukasz_2.kurierai.Interface.PostItemInterface;
import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.Type_Item;

import java.io.ByteArrayOutputStream;
import java.util.Vector;

public class ManagerData implements ManagerDataInterface {
    private Vector<Post> vectorPost;
    private Vector<Type_Item> vectorType;

    public ManagerData() {
        this.vectorPost = new Vector<>();
        this.vectorType = new Vector<>();
    }

    @Override
    public void setPost_Image(Post_Item post_image) {
        Post post = new Post(post_image);
        vectorPost.addElement(post); //wywala blad!
    }

    @Override
    public void setType_Item(Type_Item type) {
        Type_Item Type = type;
        vectorType.addElement(Type);
    }

    public Post_Item getPost_Image(int id) {
        Post_Item postItem = null;
        for(Post_Item post_item: vectorPost){
            if(post_item.getID()==id){
                postItem = post_item;
                break;
            }
        }
        return postItem;
    }
    public Post getPostNext(){
        return vectorPost.get(vectorPost.size()-1);
    }

    public Type_Item getTypeNext() { return vectorType.get(vectorType.size()-1); }

    protected class Post extends Post_Item implements PostItemInterface {
        protected Post(int ID, String nameItem, String descriptionItem, byte[] imageItem, Double cost, Integer Type) {
            super(ID, nameItem, descriptionItem, imageItem, cost, Type);
        }
        public Post(Post_Item post_item){
            super (post_item);
        }

        public Post(){
            super(1,"","",null,0.0,0);
        }

        @Override
        public String getName() {
            return NameItem;
        }

        @Override
        public String getDescription() {
            return DescriptionItem;
        }

        @Override
        public Double getCost() {
            return Cost;
        }

        @Override
        public byte[] getImageView() { return ImageItem;
        }
        public String getImageString(){
            return new String(ImageItem);
        }
        public Integer getType() {
            return Type;
        }

        private byte[] getBytesFromBitmap(Bitmap bitmap) {
            if (bitmap!=null) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                return stream.toByteArray();
            }
            return null;
        }
    }
}
