package com.example.myapplication.recycleView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {
    private Context c;
    private ArrayList<SanPham> listSP;

    public SanPhamAdapter(Context c, ArrayList<SanPham> listSP) {
        this.c = c;
        this.listSP = listSP;
    }

    @NonNull
    @Override
    public SanPhamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)c).getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_recycle_view, parent, false);
        return new SanPhamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.ViewHolder holder, int position) {
        holder.txtTen.setText(listSP.get(position).getTen());
        holder.txtGia.setText(listSP.get(position).getGia());
    }

    @Override
    public int getItemCount() {
        return listSP.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTen, txtGia;
        public ViewHolder(@NonNull View view) {
            super(view);
            txtTen = view.findViewById(R.id.txtTen);
            txtGia = view.findViewById(R.id.txtGia);
        }
    }
}
