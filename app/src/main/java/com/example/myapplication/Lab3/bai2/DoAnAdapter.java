package com.example.myapplication.Lab3.bai2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class DoAnAdapter extends BaseAdapter {
    Context ct;
    ArrayList<DoAn> listDA = new ArrayList<>();

    public DoAnAdapter(Context ct, ArrayList<DoAn> listDA) {
        this.ct = ct;
        this.listDA = listDA;
    }

    @Override
    public int getCount() {
        return listDA.size();
    }

    @Override
    public Object getItem(int i) {
        return listDA.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inf = ((Activity)ct).getLayoutInflater();
        view = inf.inflate(R.layout.do_an, viewGroup, false);
        ImageView img = view.findViewById(R.id.ivDoAn);
        TextView txt = view.findViewById(R.id.tvDoAn);
        EditText et = view.findViewById(R.id.txtGia);
        img.setImageResource(listDA.get(i).getHinh());
        txt.setText(listDA.get(i).getTen());
        et.setText("" + listDA.get(i).getGia());

        return view;
    }
}
