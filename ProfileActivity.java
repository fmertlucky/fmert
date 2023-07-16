package com.example.zhujiemian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewUsername = findViewById(R.id.textViewName);
        username = getIntent().getStringExtra("username");

        // 在 TextView 中显示用户名
        textViewUsername.setText(username);

        // 其他逻辑和操作
        Button buttonReview = findViewById(R.id.buttonReview);
        buttonReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到评价页面
                Intent intent = new Intent(ProfileActivity.this, ReviewsActivity2.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到下单页面
                Intent intent = new Intent(ProfileActivity.this, HousesActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

    }
    public void openOrdersActivity1(View view) {
        // 处理点击按钮的操作，打开订单页面
        Intent intent = new Intent(this, OrdersActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public void showInput(EditText editTextInput,TextView textViewOutput) {
        String inputText = editTextInput.getText().toString();
        textViewOutput.setText(inputText);
    }

}
