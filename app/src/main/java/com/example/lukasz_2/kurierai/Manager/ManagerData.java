package com.example.lukasz_2.kurierai.Manager;

import com.example.lukasz_2.kurierai.Interface.ManagerDataInterface;
import com.example.lukasz_2.kurierai.Model.Post_Item;

import java.util.Vector;

public class ManagerData implements ManagerDataInterface {
    private Vector<Post_Item> vector;

    @Override
    public void setPost_Image(Post_Item post_image) {
        vector.add(post_image);
    }

    @Override
    public Post_Item setPost_Image(int id) {
        Post_Item postItem = null;
        for(Post_Item post_item:vector){
            if(post_item.getID()==id){
                postItem = post_item;
                break;
            }
        }
        return postItem;
    }
}
