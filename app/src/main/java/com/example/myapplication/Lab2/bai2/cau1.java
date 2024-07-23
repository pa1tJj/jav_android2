package com.example.myapplication.Lab2.bai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class cau1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cau1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bt10, bt7, btNext1;
        bt10 = findViewById(R.id.m10);
        bt7 = findViewById(R.id.r7);
        btNext1 = findViewById(R.id.btNext1);
        btNext1.setVisibility(View.INVISIBLE);
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btNext1.setVisibility(View.VISIBLE);
                Toast.makeText(cau1.this, "Messi là Dê...bạn giỏi đấy", Toast.LENGTH_SHORT).show();
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btNext1.setVisibility(View.INVISIBLE);
                Toast.makeText(cau1.this, "Stupid!..Phó GOAT may ra", Toast.LENGTH_SHORT).show();
            }
        });

        btNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(cau1.this, cau2.class);
                startActivity(in);
            }
        });
    }
}