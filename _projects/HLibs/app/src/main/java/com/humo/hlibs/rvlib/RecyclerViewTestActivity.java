package com.humo.hlibs.rvlib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.humo.hlibs.R;
import com.humo.rvlib.recyclerview.HRAdapter;
import com.humo.rvlib.recyclerview.HRListener;
import com.humo.rvlib.recyclerview.HRViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humo on 2017/12/5 15:32.
 */

public class RecyclerViewTestActivity extends Activity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;
    HRAdapter hrAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this);
        hrAdapter = new HRAdapter() {
            @Override
            public HRViewHolder getHolder(ViewGroup parent) {
                return new RecyclerViewHolder(RecyclerViewTestActivity.this, parent, hrListener);
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(hrAdapter);

        //填充数据
        List list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i + " --- ");
        }

        hrAdapter.addMore(list);
    }

    //点击事件可直接写在viewHolder中，也可使用事件回调，如果不需要，直接传null
    HRListener hrListener = new HRListener() {
        @Override
        public void onItemClick(int position) {

            //选中点击项
            hrAdapter.setSelected(position);
            Toast.makeText(getApplicationContext(), "select " + position, Toast.LENGTH_SHORT).show();
        }
    };
}