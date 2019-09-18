package com.example.lukasz_2.kurierai.Tools;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.lukasz_2.kurierai.Model.List;
import com.example.lukasz_2.kurierai.Model.Message_Iteam;
import com.example.lukasz_2.kurierai.Model.News;
import com.example.lukasz_2.kurierai.Model.Post_Item;
import com.example.lukasz_2.kurierai.Model.Type_Item;
import java.util.Date;
import java.util.Vector;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static int version = 1;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DataBaseHelper(Context context) {
        super(context,
        TableInfo_DB_Post.Table_Name,
        null,
        version);
    }
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
            System.out.println(TableInfo_DB_Post.SQL_Create_Table +
                    " " + TableInfo_DB_Type.SQL_Create_Table +
                    " " + TableInfo_DB_Message.SQL_Create_Table +
                    " " + TableInfo_DB_News.SQL_Create_Table +
                    " " + TableInfo_DB_Order.SQL_Create_Table +
                    " " + TableInfo_DB_AdminTable.SQL_Create_Table +
                    " " + TableInfo_DB_List.SQL_Create_Table);
           db.execSQL(TableInfo_DB_Post.SQL_Create_Table);
           db.execSQL(TableInfo_DB_Type.SQL_Create_Table);
           db.execSQL(TableInfo_DB_Message.SQL_Create_Table);
           db.execSQL(TableInfo_DB_News.SQL_Create_Table);
           db.execSQL(TableInfo_DB_Order.SQL_Create_Table);
           db.execSQL(TableInfo_DB_AdminTable.SQL_Create_Table);
           db.execSQL(TableInfo_DB_List.SQL_Create_Table);
       }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println(TableInfo_DB_Post.SQL_DELETE_TABLE +
                " " + TableInfo_DB_Type.SQL_DELETE_TABLE +
                " " + TableInfo_DB_Message.SQL_DELETE_TABLE +
                " " + TableInfo_DB_News.SQL_DELETE_TABLE +
                " " + TableInfo_DB_Order.SQL_DELETE_TABLE +
                " " + TableInfo_DB_AdminTable.SQL_DELETE_TABLE+
                " " + TableInfo_DB_List.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_Post.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_Type.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_Message.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_News.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_Order.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_AdminTable.SQL_DELETE_TABLE);
        db.execSQL(TableInfo_DB_List.SQL_DELETE_TABLE);
        //onCreate(db);
    }

    public void addPost_Item(Integer id_Post, String Name, String Description, Double Cost, Integer Type, byte[] MediumBitmap){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo_DB_Post.Table_Column_ID_Post,id_Post);
        values.put(TableInfo_DB_Post.Table_Column_Name, Name);
        values.put(TableInfo_DB_Post.Table_Column_Description, Description);
        values.put(TableInfo_DB_Post.Table_Column_Cost, Cost);
        values.put(TableInfo_DB_Post.Table_Column_Type, Type);
        values.put(TableInfo_DB_Post.Table_Column_Image, MediumBitmap);
        db.insertOrThrow(TableInfo_DB_Post.Table_Name,null,values);
    }
    
    private Cursor getAllPost(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_Post.Table_Column_ID_Post,
                TableInfo_DB_Post.Table_Column_Name,
                TableInfo_DB_Post.Table_Column_Description,
                TableInfo_DB_Post.Table_Column_Cost,
                TableInfo_DB_Post.Table_Column_Type,
                TableInfo_DB_Post.Table_Column_Image};
        Cursor cursor = db.query(TableInfo_DB_Post.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }
    
    public void addType_Item(Integer id_Type, String Name, String Description, byte[] MediumBitmap){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo_DB_Type.Table_Column_ID_Post,id_Type);
        values.put(TableInfo_DB_Type.Table_Column_Name, Name);
        values.put(TableInfo_DB_Type.Table_Column_Description, Description);
        values.put(TableInfo_DB_Type.Table_Column_Image, MediumBitmap);
        db.insertOrThrow(TableInfo_DB_Type.Table_Name,null,values);
    }
    
    private Cursor getAllType(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_Type.Table_Column_ID_Post,
                TableInfo_DB_Type.Table_Column_Name,
                TableInfo_DB_Type.Table_Column_Description,
                TableInfo_DB_Type.Table_Column_Image};
        Cursor cursor = db.query(TableInfo_DB_Type.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }
    
    public void addMessage_Item(Integer id_Message, String Description, Integer Status, Integer Order){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo_DB_Message.Table_Column_ID_Post,id_Message);
        values.put(TableInfo_DB_Message.Table_Column_Description, Description);
        values.put(TableInfo_DB_Message.Table_Column_Status, Status);
        values.put(TableInfo_DB_Message.Table_Column_ID_Order, Order);
        db.insertOrThrow(TableInfo_DB_Message.Table_Name,null,values);
    }
    
    private Cursor getAllMessage(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_Message.Table_Column_ID_Post,
                TableInfo_DB_Message.Table_Column_Description,
                TableInfo_DB_Message.Table_Column_Status,
                TableInfo_DB_Message.Table_Column_ID_Order};
        Cursor cursor = db.query(TableInfo_DB_Message.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }
    
    public void addOrder_Item(Integer id_Order, Integer Id_User, Integer Id_List, Integer Status, Date date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo_DB_Order.Table_Column_ID_Post,id_Order);
        values.put(TableInfo_DB_Order.Table_Column_ID_User, Id_User);
        values.put(TableInfo_DB_Order.Table_Column_ID_List, Id_List);
        values.put(TableInfo_DB_Order.Table_Column_Status, Status);
        values.put(TableInfo_DB_Order.Table_Column_Date, String.valueOf(date));
        db.insertOrThrow(TableInfo_DB_Order.Table_Name,null,values);
    }
    
    private Cursor getAllOrder(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_Order.Table_Column_ID_Post,
                TableInfo_DB_Order.Table_Column_ID_User,
                TableInfo_DB_Order.Table_Column_ID_List,
                TableInfo_DB_Order.Table_Column_Status,
                TableInfo_DB_Order.Table_Column_Date};
        Cursor cursor = db.query(TableInfo_DB_Order.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }
    
    public void addNews_Item(Integer id_News, String Description, Integer Status){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableInfo_DB_News.Table_Column_ID_Post,id_News);
        values.put(TableInfo_DB_News.Table_Column_Description, Description);
        values.put(TableInfo_DB_News.Table_Column_Status, Status);
        db.insertOrThrow(TableInfo_DB_News.Table_Name,null,values);
    }
    private Cursor getAllList(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_List.Table_Column_ID_Post,
                TableInfo_DB_List.Table_Column_ID_Product};
        Cursor cursor = db.query(TableInfo_DB_List.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }

    private Cursor getAllNews(){
        SQLiteDatabase db = getReadableDatabase();
        String[] kolumns = {TableInfo_DB_News.Table_Column_ID_Post,
                TableInfo_DB_News.Table_Column_Description,
                TableInfo_DB_News.Table_Column_Status};
        Cursor cursor = db.query(TableInfo_DB_Type.Table_Name,kolumns,null,null,null,null,null);
        return cursor;
    }
    
    public Vector<Post_Item> selectAllPost(){
        Cursor k = getAllPost();
       Vector<Post_Item> v = new Vector<>();
        while(k.moveToNext()){
           Post_Item.BilderPost_Item bulid = new Post_Item.BilderPost_Item();
           bulid.setID(k.getInt(1));
           bulid.setNameItem(k.getString(2));
           bulid.setDescriptionItem(k.getString(3));
           bulid.setCost(k.getDouble(4));
           bulid.setType(k.getInt(5));
           bulid.setImageView(k.getBlob(6));
           v.add(bulid.build());
        }
        return v;
    }
    
    public Vector<Type_Item> selectAllType(){
        Cursor k = getAllType();
        Vector<Type_Item> v = new Vector<>();
        while(k.moveToNext()){
            Type_Item.BuliderType_Item bulider = new Type_Item.BuliderType_Item();
            bulider.setId(k.getInt(1));
            bulider.setName(k.getString(2));
            bulider.setDescription(k.getString(3));
            bulider.setBitmap(k.getBlob(4));
            v.add(bulider.bulid());
        }
        return v;
    }
    
    public Vector<News> selectAllNews(){
        Cursor k = getAllNews();
        Vector<News> v = new Vector<>();
        while(k.moveToNext()){
            News.Bulider_News bulider = new News.Bulider_News();
													bulider.setId(k.getInt(1));
            bulider.setDescription(k.getString(2));
            bulider.setStatus(k.getInt(3));
            v.add(bulider.bulid());
        }
        return v;
    }
    
    public Vector<Message_Iteam> selectAllMessage_Item(){
        Cursor k = getAllMessage();
        Vector<Message_Iteam> v = new Vector<>();
   						while(k.moveToNext()){
   			Message_Iteam.Bulider_Message_Iteam bulider = new Message_Iteam.Bulider_Message_Iteam();
            bulider.setId(k.getInt(1));
            bulider.setDescription(k.getString(2));
            bulider.setStatus(k.getInt(3));
            bulider.setOrder(k.getInt(4));
            v.add(bulider.bulid());
        }
    return v;
    }
    
    public Vector<List> selectAllList(){
        Cursor k = getAllList();
        Vector<List> v = new Vector<>();
        while(k.moveToNext()){
            List.Bulider_List bulider = new List.Bulider_List();
            bulider.setId_List(k.getInt(1));
            bulider.setId_product(k.getInt(2));
            v.add(bulider.bulid());
        }
        return v;
    }
}
class TableInfo_DB_Post implements BaseColumns {
    public TableInfo_DB_Post() {}

    static String Table_Name = "DB_POST";
    static String Table_Column_ID_Post = "ID_Post";
    static String Table_Column_Name = "Name";
    static String Table_Column_Description = "Description";
    static String Table_Column_Cost = "Cost";
    static String Table_Column_Type = "Type";
    static String Table_Column_Image = "Image";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_Name + " TEXT NOT NULL, " +
            Table_Column_Description + " TEXT, " +
            Table_Column_Cost + " DOUBLE, " +
            Table_Column_Type + " INTEGER," +
            Table_Column_Image + " MEDIUMBLOB);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_Type implements BaseColumns {
    public TableInfo_DB_Type() {}

    static String Table_Name = "DB_Type";
    static String Table_Column_ID_Post = "ID_type";
    static String Table_Column_Name = "Name";
    static String Table_Column_Description = "Description";
    static String Table_Column_Image = "Image";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_Name + " TEXT NOT NULL, " +
            Table_Column_Description + " TEXT, " +
            Table_Column_Image + " MEDIUMBLOB);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_Message implements BaseColumns {
    public TableInfo_DB_Message() {}

    static String Table_Name = "DB_Message";
    static String Table_Column_ID_Post = "ID_message";
    static String Table_Column_Description = "Description";
    static String Table_Column_Status = "Status";
    static String Table_Column_ID_Order = "Orderr";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_Description + " TEXT, " +
            Table_Column_Status + " Integer NOT NULL, "+
            Table_Column_ID_Order + " Integer);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_News implements BaseColumns {
    public TableInfo_DB_News() {}

    static String Table_Name = "DB_News";
    static String Table_Column_ID_Post = "ID_news";
    static String Table_Column_Description = "Description";
    static String Table_Column_Status = "Status";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_Description + " TEXT, " +
            Table_Column_Status + " Integer NOT NULL);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_Order implements BaseColumns {
    public TableInfo_DB_Order() {}

    static String Table_Name = "DB_Order";
    static String Table_Column_ID_Post = "ID_order";
    static String Table_Column_ID_User = "Id_user";
    static String Table_Column_ID_List = "Id_list";
    static String Table_Column_Status = "Status";
    static String Table_Column_Date = "Date";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_ID_User + " INTEGER NOT NULL, " +
            Table_Column_ID_List + " INTEGER, "+
            Table_Column_Status + "INTEGER, "+
            Table_Column_Date + " TEXT);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_AdminTable implements BaseColumns {
    public TableInfo_DB_AdminTable() {}

    static String Table_Name = "DB_AdminTable";
    static String Table_Column_ID_Post = "ID_admintable";
    static String Table_Column_Version = "Version";
    static String Table_Column_Date = "Date";
    static String Table_Column_Key = "Key";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_Version + " Double NOT NULL, " +
            Table_Column_Date + " TEXT, "+
            Table_Column_Key + "INTEGER);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}
class TableInfo_DB_List implements BaseColumns {
    public TableInfo_DB_List() {}

    static String Table_Name = "DB_List";
    static String Table_Column_ID_Post = "ID_list";
    static String Table_Column_ID_Product = "ID_Product";
    static String SQL_Create_Table = "CREATE TABLE " + Table_Name + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            Table_Column_ID_Post + " INTEGER NOT NULL, " +
            Table_Column_ID_Product + "INTEGER);";
    static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + Table_Name + ";";
}