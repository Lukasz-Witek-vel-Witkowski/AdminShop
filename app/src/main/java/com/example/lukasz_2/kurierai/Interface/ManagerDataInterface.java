package com.example.lukasz_2.kurierai.Interface;

import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.Type_Item;

public interface ManagerDataInterface {
    public void setPost_Image(Post_Item post_image);
    public void setType_Item(Type_Item type);
    public Post_Item getPost_Image(int id);
}
