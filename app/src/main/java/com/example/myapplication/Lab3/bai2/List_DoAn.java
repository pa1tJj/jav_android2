package com.example.myapplication.Lab3.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class List_DoAn extends AppCompatActivity {

    ArrayList<DoAn> listDA = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_do_an);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(R.id.lvDoAn);
        listDA.add(new DoAn(R.drawable.banhcanh, "Bánh canh", 530000.0));
        listDA.add(new DoAn(R.drawable.banhtrang, "Bánh tráng", 25000.0));
        listDA.add(new DoAn(R.drawable.buncha, "Bún chả", 83000.0));
        DoAnAdapter da = new DoAnAdapter(this, listDA);
        lv.setAdapter(da);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(List_DoAn.this, listDA.get(i).getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}