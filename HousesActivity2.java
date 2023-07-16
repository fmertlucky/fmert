package com.example.zhujiemian;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HousesActivity2 extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private String name,username;
    private String selectedOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);

        listView = findViewById(R.id.listView);
        dbHelper = new MyDatabaseHelper(this);
        username = getIntent().getStringExtra("username");

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButtonToday = findViewById(R.id.radioButton_today);
        RadioButton radioButtonTomorrow = findViewById(R.id.radioButton_tomorrow);
        RadioButton radioButtonDayAfterTomorrow = findViewById(R.id.radioButton_day_after_tomorrow);

        // 设置单选框的选择变化监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton_today) {
                    selectedOption = "remainingRooms1";
                    displayHouses();
                    Toast.makeText(HousesActivity2.this, "今天", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton_tomorrow) {
                    selectedOption = "remainingRooms2";
                    displayHouses();
                    Toast.makeText(HousesActivity2.this, "明天", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton_day_after_tomorrow) {
                    selectedOption = "remainingRooms3";
                    displayHouses();
                    Toast.makeText(HousesActivity2.this, "后天", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 初始化变量的初始值
        selectedOption = "remainingRooms1";

        displayHouses();
    }

    private void displayHouses() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        name = getIntent().getStringExtra("name");

        final Cursor cursor = db.rawQuery("SELECT id AS _id, house, location,"+ selectedOption+ " FROM houses WHERE house = ?", new String[]{String.valueOf(name)});

        String[] fromColumns = {"_id", "house", "location", selectedOption};
        int[] toViews = {R.id.textId, R.id.textName, R.id.textLocation, R.id.textRemainingRooms};

        adapter = new SimpleCursorAdapter(this, R.layout.house_item, cursor, fromColumns, toViews, 0) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Button buttonOrder = view.findViewById(R.id.buttonOrder);

                buttonOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cursor.moveToPosition(position);
                        int remainingRooms = cursor.getInt(cursor.getColumnIndex(selectedOption));

                        if (remainingRooms > 0) {
                            int houseId = cursor.getInt(cursor.getColumnIndex("_id"));
                            String houseName = cursor.getString(cursor.getColumnIndex("house"));
                            createOrder(houseId, houseName);
                            displayHouses(); // 更新民宿表数据并重新显示
                            Toast.makeText(HousesActivity2.this, "下单成功，已更新剩余房间", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(HousesActivity2.this, "剩余房间不足，无法下单", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                return view;
            }
        };

        listView.setAdapter(adapter);
    }

    private void createOrder(int houseId, String houseName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String currentTime = getCurrentTime();


        // 创建通知信息并插入到通知表格中
        ContentValues values0 = new ContentValues();
        values0.put("imf","下单成功");
        values0.put("name",username);
        values0.put("data", currentTime);
        db.insert("imforms", null, values0);

        if(selectedOption == "remainingRooms2"){
            currentTime = addDays(currentTime,1);
        } else if (selectedOption == "remainingRooms3") {
            currentTime = addDays(currentTime,2);
        }

        // 创建订单信息并插入到 orders 表格中
        ContentValues values = new ContentValues();
        values.put("house", houseName);
        values.put("date", currentTime);
        values.put("name", username);
        db.insert("orders", null, values);


        // 更新民宿表格中对应民宿的剩余房间量
        db.execSQL("UPDATE houses SET "+selectedOption+"  = "+selectedOption+" - 1 WHERE id = ?", new String[]{String.valueOf(houseId)});

        db.close();
    }
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }
    private String addDays(String date, int daysToAdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(date));
            calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
