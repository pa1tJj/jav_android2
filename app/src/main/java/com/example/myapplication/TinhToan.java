package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TinhToan extends AppCompatActivity {

    TextView kq;
    private String tinhToan(double s1, double s2, String op) {
        String s = "";
        switch(op) {
            case "+":
                s = "Tổng:" + (s1 + s2);
                break;
            case "-" :
                s = "Hiệu:" + (s1 - s2);
                break;
            case "*" :
                s = "Tích:" + (s1 * s2);
                break;
            case "/" :
                s = "Thương:" + (s1 / s2);
                break;
        }
        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tinh_toan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText so1 = findViewById(R.id.txtSo1);
        EditText so2 = findViewById(R.id.txtSo2);
        kq = findViewById(R.id.txtKq);
        Button btcong = findViewById(R.id.btCong);
        btcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss1 = so1.getText().toString();
                String ss2 = so2.getText().toString();
                double n1, n2;
                try {
                    n1 = Double.parseDouble(ss1);
                    n2 = Double.parseDouble(ss2);
                    String tinh = tinhToan(n1, n2, "+");
                    kq.setText(tinh);
                    Toast.makeText(getApplicationContext(), tinh, Toast.LENGTH_SHORT).show();
                } catch(NumberFormatException e) {

                }
            }
        });


    }
}