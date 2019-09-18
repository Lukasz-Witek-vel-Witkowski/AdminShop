package com.example.lukasz_2.kurierai.Manager;

import android.database.sqlite.SQLiteDatabase;

import com.android.volley.RequestQueue;
import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.Type_Item;
import com.example.lukasz_2.kurierai.Tools.DataBaseHelper;

public class Manager extends ManagerSQL {
    private static Manager ourInstance = null;
    private static SQLiteDatabase sqLiteDatabase;
    private ManagerApp managerApp;
    private ManagerData managerData;
    private static DataBaseHelper dataBaseHelper;
    private static RequestQueue que;

    public static Manager getInstance() {
        if (ourInstance == null)
            ourInstance = new Manager();
        return ourInstance;

    }

    private Manager() {
        super();
        managerData = new ManagerData();
        managerApp = ManagerApp.getInstance();

    }
    public void setQue(RequestQueue q){
        que = q;
    }
    public static RequestQueue getQUE(){
        return que;
    }
    public void onCreative() {
        //dataBaseHelper.onUpgrade(sqLiteDatabase,1,1);
        dataBaseHelper.onCreate(sqLiteDatabase);
    }
    public void deleteSQL(){
         dataBaseHelper.onUpgrade(sqLiteDatabase,1,1);
    }

    public void savePost(ManagerData.Post post) {
        System.out.printf("post_id = %d Name = %s Description = %s Cost = %s Type = %d Image = %s%n", post.getID(), post.getName(), post.getDescription(), post.getCost(), post.getType(), post.getImageString());
        dataBaseHelper.addPost_Item(post.getID(), post.getName(), post.getDescription(), post.getCost(), post.getType(), post.getImageView());
    }

    public void saveType(Type_Item type){
        Type_Item.BuliderType_Item bulid = new Type_Item.BuliderType_Item();
        bulid.setType(type);
        System.out.printf("post_id = %d Name = %s Description = %s Cost = %s Type = %d Image = %s%n", bulid.getId(), bulid.getName(), bulid.getDescription(), new String(bulid.getBitmap()));
        dataBaseHelper.addType_Item(bulid.getId(), bulid.getName(), bulid.getDescription(), bulid.getBitmap());
    }

    public static boolean isEmpty() {
        if (ourInstance == null) return true;
        return false;
    }

    public void SetSQL(SQLiteDatabase sqLiteData, DataBaseHelper dataBase){
        sqLiteDatabase = sqLiteData;
        dataBaseHelper = dataBase;
    }

    public void setPost_Image(Post_Item build) {
        managerData.setPost_Image(build);
    }

   public void setType_Item(Type_Item type) {managerData.setType_Item(type);}

    public void Post_save_to_SQL() {
        savePost(managerData.getPostNext());
    }

    public void Type_save_to_SQL() {saveType(managerData.getTypeNext());}
}
