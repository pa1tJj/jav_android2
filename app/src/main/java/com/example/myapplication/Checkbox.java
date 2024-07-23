package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkbox extends AppCompatActivity {

    Button chon;
    TextView hienThi;
    CheckBox xemPhim, ngheNhac, caHat, duLich, docSach, daBong;

    public void anhXa() {
        chon = findViewById(R.id.btChon);
        hienThi = findViewById(R.id.tvHienThi);
        xemPhim = findViewById(R.id.cbPhim);
        ngheNhac = findViewById(R.id.cbNhac);
        caHat = findViewById(R.id.cbCaHat);
        duLich = findViewById(R.id.cbDuLich);
        docSach = findViewById(R.id.cbDocSach);
        daBong = findViewById(R.id.cbBong);
    }

    public void click() {
        chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soThich = "";
                if(xemPhim.isChecked()) {
                    soThich += xemPhim.getText().toString() + "\n";
                }
                if (ngheNhac.isChecked()) {
                    soThich += ngheNhac.getText().toString() + "\n";
                }
                if (caHat.isChecked()) {
                    soThich += caHat.getText().toString() + "\n";
                }
                if (duLich.isChecked()) {
                    soThich += duLich.getText().toString() + "\n";
                }
                if (docSach.isChecked()) {
                    soThich += docSach.getText().toString() + "\n";
                }
                if(daBong.isChecked()) {
                    soThich += daBong.getText().toString() + "\n";
                }
                hienThi.setText(soThich);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_box);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        anhXa();
        click();
    }
}