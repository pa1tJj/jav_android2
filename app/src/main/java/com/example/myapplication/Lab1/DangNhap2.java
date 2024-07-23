package com.example.myapplication.Lab1;

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
import com.example.myapplication.R;

public class DangNhap2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText tenDangNhap = findViewById(R.id.txtTenDangNhap);
        EditText matKhauDangNhap = findViewById(R.id.txtMatKhau);

        Button btDangKy = findViewById(R.id.btDangKy);
        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DangNhap2.this, DangKy2.class);
                startActivity(in);
            }
        });
        Button btDangNhap = findViewById(R.id.btDangNhap);
        btDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = getIntent();
                Bundle b = in.getExtras();
                if(b != null) {
                    String ten = b.getString("tendangnhap");
                    String mk = b.getString("matkhau");
                    boolean u = ten.equals(tenDangNhap.getText().toString());
                    boolean p = mk.equals(matKhauDangNhap.getText().toString());
                    if(u && p) {
                        Toast.makeText(DangNhap2.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DangNhap2.this, "đăng nhập thất bai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DangNhap2.this, "chua có tài khoản", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}