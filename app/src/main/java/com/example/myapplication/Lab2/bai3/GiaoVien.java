package com.example.myapplication.Lab2.bai3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class GiaoVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giao_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent in = getIntent();
        Bundle b = in.getExtras();
        TextView ma = findViewById(R.id.tvMa);
        TextView ten = findViewById(R.id.tvHoTen);
        TextView gt = findViewById(R.id.tvGioiTinh);
        TextView st = findViewById(R.id.tvSoThich);
        String maGiaoVien = b.getString("magv");
        String hoTen = b.getString("hoten");
        String gioiTinh = b.getString("gioitinh");
        String soth = b.getString("sothich");
        ma.setText(maGiaoVien);
        ten.setText(hoTen);
        gt.setText(gioiTinh);
        st.setText(soth);
        Button back = findViewById(R.id.btBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(GiaoVien.this, ThongTinGiaoVien.class);
                startActivity(in);
            }
        });
    }
}