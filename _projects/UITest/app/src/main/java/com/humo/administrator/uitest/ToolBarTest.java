package com.humo.administrator.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * 用toolbar之前首先要将主题改为md风格的
 * Material Design的Theme
 * md的主题有：
 * •@android:style/Theme.Material (dark version)
 * •@android:style/Theme.Material.Light (light version)
 * •@android:style/Theme.Material.Light.DarkActionBar
 * <p>
 * 与之对应的Compat Theme:
 * •Theme.AppCompat
 * •Theme.AppCompat.Light
 * •Theme.AppCompat.Light.DarkActionBar
 * 当然为了兼容低版本我们使用compat theme
 * 先在res/values/styles.xml 中增加一个名为AppThemeBase的style
 * <p>
 * <p>
 * Created by zhxumao on 2017/11/30 17:08.
 */

public class ToolBarTest extends AppCompatActivity {
    private Toolbar toolbar;//兼容旧版本需要AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);
        findView();
        init();
    }

    private void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(ToolBarTest.this, "option_1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_2:
                Toast.makeText(ToolBarTest.this, "option_2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_3:
                Toast.makeText(ToolBarTest.this, "option_3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
