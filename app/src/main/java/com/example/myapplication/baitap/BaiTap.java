package com.example.myapplication.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.Lab4.ThucDon;
import com.example.myapplication.R;

public class BaiTap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button lab1, lab2, lab3, lab4, lab5;
        lab1 = findViewById(R.id.btLab1);
        lab2 = findViewById(R.id.btLab2);
        lab3 = findViewById(R.id.btLab3);
        lab4 = findViewById(R.id.btLab4);
        lab5 = findViewById(R.id.btLab5);
        lab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BaiTap.this, phan_lap1.class);
                startActivity(in);
            }
        });
        lab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BaiTap.this, phan_lap2.class);
                startActivity(in);
            }
        });
        lab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BaiTap.this, phan_lap3.class);
                startActivity(in);
            }
        });
        lab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BaiTap.this, ThucDon.class);
                startActivity(in);
            }
        });
        lab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BaiTap.this, phan_lap1.class);
                startActivity(in);
            }
        });
    }
}