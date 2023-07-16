package com.example.zhujiemian;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity2 extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private String  username ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews2);

        listView = findViewById(R.id.listView2);
        dbHelper = new MyDatabaseHelper(this);
        username = getIntent().getStringExtra("username");

        displayOrders();
    }

    private void displayOrders() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id AS _id,order_id,name,house,data,rating FROM reviews WHERE name = ?",new String[]{String.valueOf(username)});

        String[] fromColumns = {"_id", "order_id","name", "house","data", "rating"};
        int[] toViews = {R.id.textOrderId,R.id.textOrderId2,R.id.textOrderId3, R.id.textHouseId, R.id.textDate ,R.id.textStatus};

        adapter = new SimpleCursorAdapter(this, R.layout.review_item, cursor, fromColumns, toViews, 0);

        listView.setAdapter(adapter);
    }
}
