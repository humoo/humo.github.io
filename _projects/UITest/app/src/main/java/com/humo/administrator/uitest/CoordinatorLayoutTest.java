package com.humo.administrator.uitest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.humo.administrator.uitest.adapter.MyAdapter;

/**
 * Created by zhxumao on 2017/12/4 12:09.
 */

public class CoordinatorLayoutTest extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_test);

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rv.setHasFixedSize(true);

        String[] strings = new String[30];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = i + " ---";
        }
        rv.setAdapter(new MyAdapter(strings));


    }


}
