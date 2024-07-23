package com.example.myapplication.Lab3.bai1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.module.sinhvien;

import java.util.ArrayList;

public class SocialAdapter extends BaseAdapter {
    private final Context ct;
    private final ArrayList<SocialNetwork> list;

    public SocialAdapter(Context ct, ArrayList<SocialNetwork> list) {
        this.ct = ct;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inf = ((Activity)ct).getLayoutInflater();
        view = inf.inflate(R.layout.list_view_social_network, viewGroup, false);
        ImageView img = view.findViewById(R.id.ivSocial);
        TextView txt = view.findViewById(R.id.tvSocial);
        img.setImageResource(list.get(i).getHinh());
        txt.setText(list.get(i).getTen());
        return view;
    }
}
