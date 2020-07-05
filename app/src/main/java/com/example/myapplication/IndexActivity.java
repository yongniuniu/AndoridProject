package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class IndexActivity extends AppCompatActivity implements  Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    @Override
    public void onItemSelected(int id) {
        Intent intent;
        switch (id){
            case 0:
                //跳转到查看竞得物品界面
                intent = new Intent(this,ItemActivity.class);
                intent.putExtra("url","");
                startActivity(intent);
            case 1:

        }
    }
}
