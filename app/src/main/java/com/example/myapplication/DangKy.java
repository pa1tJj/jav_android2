package com.example.myapplication;

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

public class DangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText dkUser = findViewById(R.id.txtDKUser);
        EditText dkPass = findViewById(R.id.txtDKPass);
        EditText confirm = findViewById(R.id.txtDKCFPass);
        Button btDK = findViewById(R.id.btDK);
        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = dkUser.getText().toString();
                String pass = dkPass.getText().toString();
                String con = confirm.getText().toString();
                if(TextUtils.isEmpty(user) | TextUtils.isEmpty(pass) | TextUtils.isEmpty(con)) {
                    Toast.makeText(DangKy.this, "chưa nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if(pass.equals(con)) {
                        Toast.makeText(DangKy.this, "thành công", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(DangKy.this, DangNhap.class);
                        Bundle b = new Bundle();
                        b.putString("username", user);
                        b.putString("pass", pass);
                        in.putExtras(b);
                        startActivity(in);
                    } else {
                        Toast.makeText(DangKy.this, "mật khẩu không khớp...nhập lại", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}