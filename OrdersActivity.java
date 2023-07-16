package com.example.zhujiemian;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdersActivity extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        username = getIntent().getStringExtra("username");
        listView = findViewById(R.id.listView);
        dbHelper = new MyDatabaseHelper(this);
        displayOrders();
    }

    private void displayOrders() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id AS _id, house, date, name FROM orders WHERE name=?",new String[]{String.valueOf(username)});

        String[] fromColumns = {"_id", "house", "date", "name"};
        int[] toViews = {R.id.textOrderId, R.id.textHouseId, R.id.textDate, R.id.textStatus};

        adapter = new SimpleCursorAdapter(this, R.layout.order_item, cursor, fromColumns, toViews, 0) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Button buttonReview = view.findViewById(R.id.buttonReview1);
                buttonReview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cursor.moveToPosition(position);
                        String houseId = cursor.getString(cursor.getColumnIndex("house"));
                        int order_id = cursor.getInt(cursor.getColumnIndex("_id"));
                        System.out.println(houseId);
                        showReviewDialog(houseId,order_id);
                    }
                });
                return view;
            }
        };
        listView.setAdapter(adapter);
    }

    private void showReviewDialog(String houseId,int order_id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_review, null);
        builder.setView(dialogView);

        EditText editReview = dialogView.findViewById(R.id.editReview);
        Button btnSubmitReview = dialogView.findViewById(R.id.btnSubmitReview);

        AlertDialog dialog = builder.create();

        btnSubmitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review = editReview.getText().toString();
                if (!TextUtils.isEmpty(review)) {
                    createReview(houseId, review,order_id);
                    dialog.dismiss();
                    Toast.makeText(OrdersActivity.this, "评价成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OrdersActivity.this, "请输入评价", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    private void createReview(String houseId, String review,int order_id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String currentTime = getCurrentTime();

        // 创建通知信息并插入到通知表格中
        ContentValues values0 = new ContentValues();
        values0.put("imf","评价成功");
        values0.put("name",username);
        values0.put("data", currentTime);
        db.insert("imforms", null, values0);

        ContentValues values = new ContentValues();
        values.put("order_id", order_id);
        values.put("name", username);
        values.put("house", houseId);
        values.put("data", currentTime);
        values.put("rating", review);
        db.insert("reviews", null, values);
        db.close();
    }
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }
}
