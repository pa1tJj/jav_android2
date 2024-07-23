package com.example.myapplication.Lab2.bai3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class ThongTinGiaoVien extends AppCompatActivity {

    EditText hoten, ma;
    RadioButton nam, nu;
    CheckBox cPhim, cNhac, cHat, cDulich, cSach, cTheduc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thong_tin_giao_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        anhXa();

        Button hienThi = findViewById(R.id.btHienThi);
        hienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ht = hoten.getText().toString();
                String magv = ma.getText().toString();
                String phim = cPhim.getText().toString();
                String nhac = cNhac.getText().toString();
                String hat = cHat.getText().toString();
                String du = cDulich.getText().toString();
                String sach = cSach.getText().toString();
                String theduc = cTheduc.getText().toString();
                String gioitinh;
                String soThich = "";
                if(nam.isChecked()) {
                    gioitinh = "nam";
                } else {
                    gioitinh = "nữ";
                }
                if(cPhim.isChecked()) {
                    soThich += phim + "\n";
                }
                if(cNhac.isChecked()) {
                    soThich += nhac + "\n";
                }
                if(cHat.isChecked()) {
                    soThich += hat + "\n";
                }
                if(cDulich.isChecked()) {
                    soThich += du + "\n";
                }
                if(cSach.isChecked()) {
                    soThich += sach + "\n";
                }
                if(cTheduc.isChecked()){
                    soThich += theduc + "\n";
                }
                
                Bundle b = new Bundle();
                b.putString("magv", magv);
                b.putString("hoten", ht);
                b.putString("gioitinh", gioitinh);
                b.putString("sothich", soThich);
                Intent in = new Intent(ThongTinGiaoVien.this, GiaoVien.class);
                in.putExtras(b);
                startActivity(in);
            }
        });

        Button btThoat = findViewById(R.id.btThoat);
        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_MAIN);
                in.addCategory(Intent.CATEGORY_HOME);
                startActivity(in);
                finish();
            }
        });
    }

    public void anhXa() {
       hoten = findViewById(R.id.txtHoTen);
        ma = findViewById(R.id.txtMaGV);
        nam = findViewById(R.id.rbNam);
        nu = findViewById(R.id.rbNu);
        cPhim = findViewById(R.id.cbXemPhim);
        cNhac = findViewById(R.id.cbNgheNhac);
        cHat = findViewById(R.id.cbCaHat);
        cDulich = findViewById(R.id.cbDuLich);
        cSach = findViewById(R.id.cbDocSach);
        cTheduc = findViewById(R.id.cbTheDuc);
    }
}