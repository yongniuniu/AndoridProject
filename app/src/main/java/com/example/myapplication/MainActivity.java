package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
   private  EditText editText1;
   private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        initView();
    }
    public void tetsgetRequest(View view) throws ExecutionException, InterruptedException {
        System.out.println(OkHttpUtil.getReuest("https://www.baidu.com"));
    }
    public void tetsgetPost(View view) throws ExecutionException, InterruptedException {
      Map<String,String> map=new HashMap<String ,String>(){{
          put("username",editText1.getText().toString());
          put("password",editText2.getText().toString());
      }};
        String result=OkHttpUtil.postReuest("http://172.18.85.254:8080/auction/api/users/login",map);
        if (result!=null && result.equals("1")){
            Intent intent=new Intent(this,IndexActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
        }
    }
    private void initView(){
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
    }


}
