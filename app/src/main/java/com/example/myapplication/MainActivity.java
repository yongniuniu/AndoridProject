package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity {

    private EditText editText5;
    private EditText editText7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText5 = findViewById(R.id.editText5);
        editText7 = findViewById(R.id.editText7);
    }

    public void testgetRequest(View view) throws ExecutionException, InterruptedException {
        System.out.println(OkHttpUtil.getRequest("http://www.baidu.com"));
    }

    public void testpostRequest(View view) throws ExecutionException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        map.put("username",editText5.getText().toString());
        map.put("userpass",editText7.getText().toString());
        System.out.println(map);
        String result = OkHttpUtil.postRequest("http://172.18.85.254:8080/auction/api/users/login",map);

        if (result != null && result.equals("1")){
            Intent intent = new Intent(this,IndexActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
        }

    }



}
