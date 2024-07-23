package com.example.myapplication.Lab1.MayTinhBoTui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class ManHinhMayTinh extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btCong, btTru, btNhan, btChia, btDauPhay, btAC, btDEL, btPhanTram, btDauBang;
    TextView ketQua, phepTinh;
    private String number;
    double lastNumber = 0, firstNumber = 0;
    boolean operator = false;
    String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh_may_tinh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        anhXa();
        btCong.setOnClickListener(view -> {
            if(operator) {
                if(status == "multi") {
                    Cong();
                } else if (status == "btHieu") {
                    Tru();
                } else if (status == "btTich") {
                    Nhan();
                } else if (status == "btThuong"){
                    Chia();
                }
            }
        });
        btTru.setOnClickListener(view -> numberClick("-"));
        btNhan.setOnClickListener(view -> numberClick("*"));
        btTru.setOnClickListener(view -> numberClick("/"));

        btDauPhay.setOnClickListener(view -> numberClick(","));
        btDauBang.setOnClickListener(view -> numberClick("="));
        btAC.setOnClickListener(view -> numberClick("AC"));
        btDEL.setOnClickListener(view -> numberClick("DEL"));
        btPhanTram.setOnClickListener(view -> numberClick("%"));
    }

    public void numberClick(String view) {
        if(number == null) {
            number = view;
        } else {
            number = number + view;
        }
        phepTinh.setText(number);
        operator = true;
    }

    public void Cong() {
        if(firstNumber == 0) {
            firstNumber = Double.parseDouble(ketQua.getText().toString());
        } else {
            lastNumber = Double.parseDouble(ketQua.getText().toString());
            firstNumber = firstNumber + lastNumber;
        }
        ketQua.setText("" + firstNumber);
    }
    public void Tru() {
        if(firstNumber == 0) {
            firstNumber = Double.parseDouble(ketQua.getText().toString());
        } else {
            lastNumber = Double.parseDouble(ketQua.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        ketQua.setText("" + firstNumber);
    }
    public void Nhan() {
        if(firstNumber == 0) {
            firstNumber = Double.parseDouble(ketQua.getText().toString());
        } else {
            lastNumber = Double.parseDouble(ketQua.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        ketQua.setText("" + firstNumber);
    }
    public void Chia() {
        if(firstNumber == 0) {
            lastNumber = Double.parseDouble(ketQua.getText().toString());
            firstNumber = lastNumber;
        } else {
            lastNumber = Double.parseDouble(ketQua.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        ketQua.setText("" + firstNumber);
    }

    public void anhXa() {
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);

        btCong = findViewById(R.id.btCong);
        btTru = findViewById(R.id.btHieu);
        btNhan = findViewById(R.id.btTich);
        btChia = findViewById(R.id.btThuong);

        btDauPhay = findViewById(R.id.btPhay);
        btDauBang = findViewById(R.id.btDauBang);
        btAC = findViewById(R.id.btAC);
        btDEL = findViewById(R.id.btDEL);
        btPhanTram = findViewById(R.id.btPhanTram);

        ketQua = findViewById(R.id.tvKetQua);
        phepTinh = findViewById(R.id.tvPhepTinh);

        bt0.setOnClickListener(view -> numberClick("0"));
        bt1.setOnClickListener(view -> numberClick("1"));
        bt2.setOnClickListener(view -> numberClick("2"));
        bt3.setOnClickListener(view -> numberClick("3"));
        bt4.setOnClickListener(view -> numberClick("4"));
        bt5.setOnClickListener(view -> numberClick("5"));
        bt6.setOnClickListener(view -> numberClick("6"));
        bt7.setOnClickListener(view -> numberClick("7"));
        bt8.setOnClickListener(view -> numberClick("8"));
        bt9.setOnClickListener(view -> numberClick("9"));
    }
}