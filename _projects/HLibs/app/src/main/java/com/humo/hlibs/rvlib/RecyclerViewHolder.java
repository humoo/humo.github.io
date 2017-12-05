package com.humo.hlibs.rvlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.humo.hlibs.R;
import com.humo.rvlib.recyclerview.HRListener;
import com.humo.rvlib.recyclerview.HRViewHolder;

/**
 * Created by Admin on 2017/12/5 15:44.
 */

public class RecyclerViewHolder extends HRViewHolder {

    private ImageView imageView;
    private TextView textView;
    private LinearLayout linearLayout;

    public RecyclerViewHolder(Context context, ViewGroup root, HRListener listener) {
        super(context, root, R.layout.item_img_text, listener);
    }

    @Override
    public void bindData(Object o, final int position, int selectedP) {

        textView.setText((String) o);

        //如果需要事件监听，可仿造以下写法
//        if (position == selectedP) {
//            linearLayout.setBackgroundColor(Color.GREEN);
//        } else {
//            linearLayout.setBackgroundColor(Color.WHITE);
//        }
//
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (getHRListener() != null) {
//                    getHRListener().onItemClick(position);
//                }
//            }
//        });
    }

    @Override
    public void bindView(View rootView) {
        imageView = rootView.findViewById(R.id.image);
        textView = rootView.findViewById(R.id.text);
        linearLayout = rootView.findViewById(R.id.linearLayout);
    }
}
