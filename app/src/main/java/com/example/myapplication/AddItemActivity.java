package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initView();
    }


    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:

                //获取用户输入的数据
                String name = editText.getText().toString();
                String desc = editText2.getText().toString();
                String remark = editText3.getText().toString();
                String price = editText4.getText().toString();
                //将数据打包称map对象
                Map<String,String> map = new HashMap<>();
                map.put("itemName",name);
                map.put("itemDesc",desc);
                map.put("itemRemark",remark);
                map.put("initPrice",price);
                map.put("kindId","1");
                map.put("avail","1");

                //发送数据
                try {
                    String result = OkHttpUtil.postRequest("http://172.18.85.254:8080/auction/api/items",map);
                    Toast.makeText(this,result,Toast.LENGTH_LONG).show();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.button5:
                Intent intent=new Intent(this,ItemActivity.class);
                startActivity(intent);

                break;
        }
    }



}
