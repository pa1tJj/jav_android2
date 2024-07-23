package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ
        EditText txtmon = findViewById(R.id.txtMon);
        RadioButton rbnam = findViewById(R.id.rbNam);
        RadioButton rbnu = findViewById(R.id.rbNu);
        Button btsubmit = findViewById(R.id.btSubmit);
        //xử  lý sự kiện
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mon = String.valueOf(txtmon.getText());
                String kq;
                if(rbnam.isChecked()) {
                    kq = "nam";
                } else {
                    kq = "nữ";
                }
                Toast.makeText(MainActivity2.this, "bạn chọn môn:" + mon + "giới tính:" + kq, Toast.LENGTH_SHORT).show();
            }
        });
    }
}