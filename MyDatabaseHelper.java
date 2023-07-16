package com.example.zhujiemian;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myapp.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createHousesTableQuery = "CREATE TABLE IF NOT EXISTS houses (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "house TEXT," +
                "location TEXT," +
                "remainingRooms1 INTEGER,"+
                "remainingRooms2 INTEGER,"+
                "remainingRooms3 INTEGER)";
        db.execSQL(createHousesTableQuery);


        String createOrdersTableQuery = "CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "house TEXT," +
                "date TEXT," +
                "name TEXT)";
        db.execSQL(createOrdersTableQuery);

        String createReviewsTableQuery = "CREATE TABLE IF NOT EXISTS reviews (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "order_id INTEGER," +
                "name TEXT," +
                "house TEXT," +
                "data TEXT," +
                "rating TEXT)";
        db.execSQL(createReviewsTableQuery);

        String createimTableQuery = "CREATE TABLE IF NOT EXISTS imforms (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "imf TEXT," +
                "name TEXT,"+
                "data TEXT)";
        db.execSQL(createimTableQuery);
        insertHouse(db, "民宿1", "四川省成都市", 5, 15, 7);
        insertHouse(db, "民宿2", "四川省绵阳市", 8, 3, 12);
        insertHouse(db, "民宿3", "四川省德阳市", 3, 20, 5);
        insertHouse(db, "民宿4", "四川省自贡市", 2, 8, 22);
        insertHouse(db, "民宿5", "四川省泸州市", 6, 11, 9);
        insertHouse(db, "民宿6", "四川省广元市", 7, 4, 18);
        insertHouse(db, "民宿7", "四川省内江市", 4, 21, 14);
        insertHouse(db, "民宿8", "四川省攀枝花市", 1, 17, 1);
        insertHouse(db, "民宿9", "四川省乐山市", 9, 6, 20);
        insertHouse(db, "民宿10", "四川省雅安市", 3, 9, 3);
        insertHouse(db, "民宿11", "四川省宜宾市", 5, 2, 13);
        insertHouse(db, "民宿12", "四川省南充市", 7, 23, 10);
        insertHouse(db, "民宿13", "四川省达州市", 2, 14, 17);
        insertHouse(db, "民宿14", "四川省遂宁市", 4, 5, 8);
        insertHouse(db, "民宿15", "四川省广安市", 6, 16, 4);
        insertHouse(db, "民宿16", "四川省巴中市", 3, 19, 23);
        insertHouse(db, "民宿17", "四川省眉山市", 8, 1, 16);
        insertHouse(db, "民宿18", "四川省资阳市", 5, 7, 2);
        insertHouse(db, "民宿19", "四川省阿坝藏族羌族自治州", 4, 13, 6);
        insertHouse(db, "民宿20", "四川省甘孜藏族自治州", 7, 10, 21);
        insertHouse(db, "民宿21", "北京市", 6, 18, 15);
        insertHouse(db, "民宿22", "上海市", 2, 12, 11);
        insertHouse(db, "民宿23", "广东省广州市", 3, 22, 19);
        insertHouse(db, "民宿24", "浙江省杭州市", 4, 3, 7);
        insertHouse(db, "民宿25", "江苏省南京市", 5, 24, 24);
        insertHouse(db, "民宿26", "湖北省武汉市", 7, 7, 5);
        insertHouse(db, "民宿27", "福建省福州市", 8, 1, 9);
        insertHouse(db, "民宿28", "湖南省长沙市", 1, 6, 2);
        insertHouse(db, "民宿29", "辽宁省沈阳市", 9, 15, 12);
        insertHouse(db, "民宿30", "山东省济南市", 2, 23, 20);
        insertHouse(db, "民宿31", "河南省郑州市", 6, 14, 6);
        insertHouse(db, "民宿32", "江西省南昌市", 3, 10, 18);
        insertHouse(db, "民宿33", "黑龙江省哈尔滨市", 7, 4, 11);
        insertHouse(db, "民宿34", "云南省昆明市", 4, 16, 15);
        insertHouse(db, "民宿35", "四川省成都市", 5, 8, 3);
        insertHouse(db, "民宿36", "四川省绵阳市", 8, 11, 14);
        insertHouse(db, "民宿37", "四川省德阳市", 3, 2, 17);
        insertHouse(db, "民宿38", "四川省自贡市", 2, 5, 10);
        insertHouse(db, "民宿39", "四川省泸州市", 6, 22, 7);
        insertHouse(db, "民宿40", "四川省广元市", 7, 20, 1);
        insertHouse(db, "民宿41", "四川省内江市", 4, 9, 19);
        insertHouse(db, "民宿42", "四川省攀枝花市", 1, 13, 23);
        insertHouse(db, "民宿43", "四川省乐山市", 9, 16, 4);
        insertHouse(db, "民宿44", "四川省雅安市", 3, 18, 12);
        insertHouse(db, "民宿45", "四川省宜宾市", 5, 3, 8);
        insertHouse(db, "民宿46", "四川省南充市", 7, 1, 24);
        insertHouse(db, "民宿47", "四川省达州市", 2, 6, 2);
        insertHouse(db, "民宿48", "四川省遂宁市", 4, 11, 16);
        insertHouse(db, "民宿49", "四川省广安市", 6, 20, 3);
        insertHouse(db, "民宿50", "四川省巴中市", 3, 9, 21);
        insertHouse(db, "民宿51", "四川省成都市", 5, 14, 5);
        insertHouse(db, "民宿52", "四川省绵阳市", 8, 7, 19);
        insertHouse(db, "民宿53", "四川省德阳市", 3, 24, 10);
        insertHouse(db, "民宿54", "四川省自贡市", 2, 19, 22);
        insertHouse(db, "民宿55", "四川省泸州市", 6, 12, 8);
        insertHouse(db, "民宿56", "四川省广元市", 7, 17, 16);
        insertHouse(db, "民宿57", "四川省内江市", 4, 10, 3);
        insertHouse(db, "民宿58", "四川省攀枝花市", 1, 5, 9);
        insertHouse(db, "民宿59", "四川省乐山市", 9, 2, 13);
        insertHouse(db, "民宿60", "四川省雅安市", 3, 23, 2);
        insertHouse(db, "民宿61", "四川省宜宾市", 5, 15, 24);
        insertHouse(db, "民宿62", "四川省南充市", 7, 8, 20);
        insertHouse(db, "民宿63", "四川省达州市", 2, 4, 7);
        insertHouse(db, "民宿64", "四川省遂宁市", 4, 20, 11);
        insertHouse(db, "民宿65", "四川省广安市", 6, 3, 18);
        insertHouse(db, "民宿66", "四川省巴中市", 3, 7, 14);
        insertHouse(db, "民宿67", "四川省眉山市", 8, 22, 5);
        insertHouse(db, "民宿68", "四川省资阳市", 5, 11, 9);
        insertHouse(db, "民宿69", "四川省阿坝藏族羌族自治州", 4, 18, 15);
        insertHouse(db, "民宿70", "四川省甘孜藏族自治州", 7, 1, 22);
        insertHouse(db, "民宿71", "北京市", 6, 16, 4);
        insertHouse(db, "民宿72", "上海市", 2, 9, 8);
        insertHouse(db, "民宿73", "广东省广州市", 3, 21, 2);
        insertHouse(db, "民宿74", "浙江省杭州市", 4, 13, 17);
        insertHouse(db, "民宿75", "江苏省南京市", 5, 6, 13);
        insertHouse(db, "民宿76", "湖北省武汉市", 7, 21, 24);
        insertHouse(db, "民宿77", "福建省福州市", 8, 4, 10);
        insertHouse(db, "民宿78", "湖南省长沙市", 1, 17, 21);
        insertHouse(db, "民宿79", "辽宁省沈阳市", 9, 15, 5);
        insertHouse(db, "民宿80", "山东省济南市", 2, 2, 12);
        insertHouse(db, "民宿81", "河南省郑州市", 6, 24, 16);
        insertHouse(db, "民宿82", "江西省南昌市", 3, 12, 23);
        insertHouse(db, "民宿83", "黑龙江省哈尔滨市", 7, 8, 19);
        insertHouse(db, "民宿84", "云南省昆明市", 4, 6, 4);
        insertHouse(db, "民宿85", "四川省成都市", 5, 23, 21);
        insertHouse(db, "民宿86", "四川省绵阳市", 8, 9, 15);
        insertHouse(db, "民宿87", "四川省德阳市", 3, 14, 11);
        insertHouse(db, "民宿88", "四川省自贡市", 2, 3, 6);
        insertHouse(db, "民宿89", "四川省泸州市", 6, 22, 3);
        insertHouse(db, "民宿90", "四川省广元市", 7, 16, 7);
        insertHouse(db, "民宿91", "四川省内江市", 4, 11, 19);
        insertHouse(db, "民宿92", "四川省攀枝花市", 1, 1, 17);
        insertHouse(db, "民宿93", "四川省乐山市", 9, 13, 14);
        insertHouse(db, "民宿94", "四川省雅安市", 3, 5, 8);
        insertHouse(db, "民宿95", "四川省宜宾市", 5, 20, 6);
        insertHouse(db, "民宿96", "四川省南充市", 7, 10, 12);
        insertHouse(db, "民宿97", "四川省达州市", 2, 18, 23);
        insertHouse(db, "民宿98", "四川省遂宁市", 4, 15, 13);
        insertHouse(db, "民宿99", "四川省广安市", 6, 21, 5);
        insertHouse(db, "民宿100", "四川省巴中市", 3, 12, 9);
        insertHouse(db, "民宿101", "江苏省苏州市", 5, 23, 11);
        insertHouse(db, "民宿102", "浙江省宁波市", 7, 8, 14);
        insertHouse(db, "民宿103", "湖北省黄石市", 2, 4, 6);
        insertHouse(db, "民宿104", "福建省厦门市", 4, 16, 23);
        insertHouse(db, "民宿105", "湖南省株洲市", 6, 2, 21);
        insertHouse(db, "民宿106", "辽宁省大连市", 3, 19, 16);
        insertHouse(db, "民宿107", "山东省青岛市", 8, 11, 8);
        insertHouse(db, "民宿108", "河南省开封市", 5, 5, 18);
        insertHouse(db, "民宿109", "江西省九江市", 4, 24, 20);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 数据库升级操作
    }

    public void insertHouse(SQLiteDatabase db,String name, String location, int remainingRooms1,int remainingRooms2,int remainingRooms3) {

        ContentValues values = new ContentValues();
        values.put("house", name);
        values.put("location", location);
        values.put("remainingRooms1", remainingRooms1);
        values.put("remainingRooms2", remainingRooms2);
        values.put("remainingRooms3", remainingRooms3);
        db.insert("houses", null, values);

    }

    public void insertOrder(String house, String date, int status) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("house", house);
        values.put("date", date);
        values.put("name", status);
        db.insert("orders", null, values);
        db.close();
    }

    public void insertReview(int order_id,String name, String house,String data, int rating) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("order_id", order_id);
        values.put("name", name);
        values.put("house", house);
        values.put("data", data);
        values.put("rating", rating);
        db.insert("reviews", null, values);
        db.close();
    }

    public Cursor getAllHouses() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM houses", null);
    }

    public Cursor getAllOrders() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM orders", null);
    }

    public Cursor getAllReviews() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM reviews", null);
    }
}
