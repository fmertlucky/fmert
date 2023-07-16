package com.example.zhujiemian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {


    private EditText editSearch;
    private EditText editSearch2;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        editSearch = findViewById(R.id.editSearch1);
        editSearch2 = findViewById(R.id.editSearch2);
        username = getIntent().getStringExtra("username");

    }

    public void openHouseActivity2(View view) {
        String name=editSearch.getText().toString().trim();
        if(name.isEmpty()){
            Toast.makeText(QueryActivity.this, "请输入查询内容", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent(this, HousesActivity2.class);
            intent.putExtra("name", name);//传值
            intent.putExtra("username", username);//传值
            startActivity(intent);
        }
    }
    public void openHouseActivity3(View view) {
        String name=editSearch2.getText().toString().trim();
        if(name.isEmpty()){
            Toast.makeText(QueryActivity.this, "请输入查询内容", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent(this, HousesActivity3.class);
            intent.putExtra("name", name);//传值
            intent.putExtra("username", username);//传值
            startActivity(intent);
        }
    }



}