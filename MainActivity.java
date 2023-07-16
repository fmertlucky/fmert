package com.example.zhujiemian;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewUsername;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUsername = findViewById(R.id.textView);
        // 获取传递过来的用户名
         username = getIntent().getStringExtra("username");

        // 在 TextView 中显示用户名
        textViewUsername.setText(username);
    }

    public void openHousesActivity(View view) {
        // 处理点击“民宿”按钮的操作，打开民宿页面
        Intent intent = new Intent(this, HousesActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void openOrdersActivity(View view) {
        // 处理点击“订单”按钮的操作，打开订单页面
        Intent intent = new Intent(this, OrdersActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void openReviewsActivity(View view) {
        // 处理点击“评价”按钮的操作，打开评价页面
        Intent intent = new Intent(this, ReviewsActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void openProfileActivity(View view) {
        // 处理点击“个人”按钮的操作，打开个人页面
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public void openQueryActivity(View view) {
        // 处理点击“个人”按钮的操作，打开个人页面
        Intent intent = new Intent(this, QueryActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public void openInformActivity(View view) {
        // 处理点击“个人”按钮的操作，打开个人页面
        Intent intent = new Intent(this, InformsActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public void openBaiduActivity(View view) {
        // 处理点击“个人”按钮的操作，打开个人页面
        Intent intent = new Intent(this, InformsActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
