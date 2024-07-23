package com.example.myapplication.module;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SchoolAdapter extends BaseAdapter {

    private final Context ct;
    private final ArrayList<sinhvien> list;

    public SchoolAdapter(Context ct, ArrayList<sinhvien> list) {
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
        view = inf.inflate(R.layout.itemspin2, viewGroup, false);
        ImageView img = view.findViewById(R.id.imgHinh);
        TextView txt = view.findViewById(R.id.txtTen);
        img.setImageResource(list.get(i).getHinh());
        txt.setText(list.get(i).getTen());
        return view;
    }
}
