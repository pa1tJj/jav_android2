package com.example.myapplication.Lab1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class DangKy2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText ten = findViewById(R.id.txtTaoTen);
        EditText mk = findViewById(R.id.txtTaoMatKhau);
        EditText taoLaiMK = findViewById(R.id.txtTaoLaiMK);

        Button btDangKy = findViewById(R.id.btTaoDK);
        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taoTen = ten.getText().toString();
                String taoMatKhau = mk.getText().toString();
                String taoLaiMatKhau = taoLaiMK.getText().toString();
                if(TextUtils.isEmpty(taoTen) | TextUtils.isEmpty(taoMatKhau) | TextUtils.isEmpty(taoLaiMatKhau)) {
                    Toast.makeText(DangKy2.this, "chưa nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if(taoMatKhau.equals(taoLaiMatKhau)) {
                        Toast.makeText(DangKy2.this, "đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(DangKy2.this, DangNhap2.class);
                        Bundle b = new Bundle();
                        b.putString("tendangnhap", taoTen);
                        b.putString("matkhau", taoMatKhau);
                        in.putExtras(b);
                        startActivity(in);
                    }else {
                        Toast.makeText(DangKy2.this, "mật khẩu không khớp...nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}