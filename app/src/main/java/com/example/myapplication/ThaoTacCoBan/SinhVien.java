package com.example.myapplication.ThaoTacCoBan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SinhVien extends AppCompatActivity {
    ArrayAdapter<SV> adapter = null;
    EditText ma, ten, gioitinh, namsinh;
    Button btthem, btsua, btxoa, btreset, btthoat;
    ListView lv;
    ArrayList<SV> listSV = new ArrayList<>();
    int vt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sinh_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();
        listSV.add(new SV("394543jds", "phan", "nam", 2004));
        adapter = new ArrayAdapter<>(SinhVien.this, android.R.layout.simple_list_item_1, listSV);
        lv.setAdapter(adapter);

        //them du lieu
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = ma.getText().toString();
                String tensv = ten.getText().toString();
                int ns = Integer.parseInt(namsinh.getText().toString());
                String gt = gioitinh.getText().toString();
                SV  sv = new SV(masv, tensv, gt, ns);
                listSV.add(sv);
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vt = i;
                SV sv = listSV.get(i);
                ma.setText(sv.getMaSinhVien());
                ten.setText(sv.getTenSinhVien());
                gioitinh.setText(sv.getGioiTinh());
                namsinh.setText("" + sv.getNamSinh());
            }
        });
        btsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = ma.getText().toString();
                String tensv = ten.getText().toString();
                int ns = Integer.parseInt(namsinh.getText().toString());
                String gt = gioitinh.getText().toString();
                SV  sv = new SV(masv, tensv, gt, ns);
                listSV.set(vt, sv);
                adapter.notifyDataSetChanged();
            }
        });


        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listSV.remove(vt);
                adapter.notifyDataSetChanged();
            }
        });

        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.setText("");
                ten.setText("");
                gioitinh.setText("");
                namsinh.setText("");
            }
        });
    }

    public void anhXa() {
        ma = findViewById(R.id.txtMa);
        ten = findViewById(R.id.txtTenSV);
        gioitinh = findViewById(R.id.txtGioiTinh);
        namsinh = findViewById(R.id.txtNam);
        btxoa = findViewById(R.id.btXoa);
        btthem = findViewById(R.id.btThem);
        btsua = findViewById(R.id.btSua);
        btreset = findViewById(R.id.btReset);
        btthoat = findViewById(R.id.btThoat);
        lv = findViewById(R.id.lvSinhVien);
    }
}