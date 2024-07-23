package com.example.myapplication.Lab4;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Lab3.bai2.DoAn;
import com.example.myapplication.R;

import java.util.ArrayList;

public class LoaiDoAnAdapter extends BaseAdapter {

    Context ct;
    ArrayList<LoaiDoAn> listDA = new ArrayList<>();

    public LoaiDoAnAdapter(Context ct, ArrayList<LoaiDoAn> listDA) {
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
        view = inf.inflate(R.layout.thucdon, viewGroup, false);
        ImageView img = view.findViewById(R.id.ivThucDon);
        TextView txt = view.findViewById(R.id.tvTen);
        TextView tvgia = view.findViewById(R.id.tvGia);
        img.setImageResource(listDA.get(i).getHinh());
        txt.setText(listDA.get(i).getTen());
        tvgia.setText("" + listDA.get(i).getGia());

        return view;
    }
}
