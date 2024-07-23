package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangNhap extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtuser = findViewById(R.id.txtUser);
        EditText txtpass = findViewById(R.id.txtPass);
        Button bt = findViewById(R.id.btDangKi);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DangNhap.this, DangKy.class);
                startActivity(in);
            }
        });

        Button btDN = findViewById(R.id.btDangNhap);
        btDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //bundle.pusString("username", user);
                Intent in = getIntent();
                Bundle b = in.getExtras();
                //sử sụng equanls để spo sánh username và pass nhận wtuwf bundle
                if(b != null) {
                    String user = b.getString("username");
                    String pass = b.getString("pass");
                    boolean u = user.equals(txtuser.getText().toString());
                    boolean p = pass.equals(txtpass.getText().toString());
                    if(u && p) {
                        Toast.makeText(DangNhap.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DangNhap.this, "đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DangNhap.this, "chua thực hiện đăng ki", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}