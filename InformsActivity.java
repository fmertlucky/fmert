package com.example.zhujiemian;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class InformsActivity extends AppCompatActivity {


    private ListView listView;
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informs);

        username = getIntent().getStringExtra("username");

        listView = findViewById(R.id.listView);
        dbHelper = new MyDatabaseHelper(this);

        displayOrders();
    }

    private void displayOrders() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id AS _id,imf,name,data FROM imforms WHERE name=?",new String[]{String.valueOf(username)});

        String[] fromColumns = {"_id", "imf","name", "data"};
        int[] toViews = {R.id.textOrderId,R.id.textOrderId2,R.id.textOrderId3, R.id.textHouseId};

        adapter = new SimpleCursorAdapter(this, R.layout.inform_item, cursor, fromColumns, toViews, 0);

        listView.setAdapter(adapter);
    }
}