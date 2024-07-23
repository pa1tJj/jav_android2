package com.example.myapplication;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.module.SchoolAdapter;
import com.example.myapplication.module.sinhvien;

import java.util.ArrayList;

public class Spiner extends AppCompatActivity {

    private ArrayList<sinhvien> listSV = new ArrayList<sinhvien>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spiner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner sp = findViewById(R.id.spin);
        //tạo dữ lieu để đổ dữ liệu lên spinner
        //String [] list = new String[] {"java", "c#", "android"};
        //tạo đối tượng adapter
//        ArrayAdapter<String > adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
//        sp.setAdapter(adapter);
        listSV.add(new sinhvien(R.drawable.logouneti, "Hà Nội"));
        listSV.add(new sinhvien(R.drawable.face, "Hồ Chí Minh"));
        listSV.add(new sinhvien(R.drawable.br, "Huế"));
        SchoolAdapter sa = new SchoolAdapter(this, listSV);
        sp.setAdapter(sa);//đọc dữ liệu trên spinner
    }
}