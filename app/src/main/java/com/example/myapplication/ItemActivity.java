package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.dummy.DummyContent;


public class ItemActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        //动态加载fragment
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.frameLayout,ItemFragment.newInstance(1))
            .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public void addItem(View view) {
        Intent intent = new Intent(this,AddItemActivity.class);
        startActivity(intent);
    }
}
