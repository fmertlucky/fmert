package com.example.zhujiemian;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewsActivity extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        listView = findViewById(R.id.listView);
        dbHelper = new MyDatabaseHelper(this);

        displayOrders();
    }

    private void displayOrders() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id AS _id,order_id,name,house,data,rating FROM reviews", null);

        String[] fromColumns = {"_id", "order_id","name", "house","data", "rating"};
        int[] toViews = {R.id.textOrderId,R.id.textOrderId2,R.id.textOrderId3, R.id.textHouseId, R.id.textDate ,R.id.textStatus};

        adapter = new SimpleCursorAdapter(this, R.layout.review_item, cursor, fromColumns, toViews, 0);

        listView.setAdapter(adapter);
    }
}
