package com.humo.hlibs.rvlib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.humo.hlibs.R;
import com.humo.rvlib.listview.HLAdapter;
import com.humo.rvlib.listview.HLViewHolder;
import com.humo.rvlib.listview.HListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humo on 2017/12/5 16:21.
 */

public class ListViewTestActivity extends Activity {

    ListView listView;
    HLAdapter hlAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_list_view);

        listView = findViewById(R.id.listView);
        hlAdapter = new HLAdapter() {
            @Override
            public HLViewHolder getHolder() {
                return new ListViewHolder(ListViewTestActivity.this, hListener);
            }
        };
        listView.setAdapter(hlAdapter);


        //填充数据
        List list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i + " --- ");
        }
        hlAdapter.addMore(list);

    }


    //点击事件可直接写在viewHolder中，也可使用事件回调，如果不需要，直接传null
    HListener hListener = new HListener() {
        @Override
        public void onItemClick(int position) {

            //选中点击项
            hlAdapter.setSelected(position);
            Toast.makeText(getApplicationContext(), "select " + position, Toast.LENGTH_SHORT).show();
        }
    };
}
