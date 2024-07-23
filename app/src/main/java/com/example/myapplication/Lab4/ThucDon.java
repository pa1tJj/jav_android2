package com.example.myapplication.Lab4;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ThucDon extends AppCompatActivity {

    ArrayList<LoaiDoAn> list = new ArrayList<>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thuc_don);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gv = findViewById(R.id.gvThucDon);
        list.add(new LoaiDoAn(R.drawable.sinhto, "Sinh tố", 70000.0));
        list.add(new LoaiDoAn(R.drawable.coffe, "Cà phê", 70000.0));
        list.add(new LoaiDoAn(R.drawable.chelien, "Chè liên", 70000.0));
        list.add(new LoaiDoAn(R.drawable.banhcanh, "Bánh canh", 53000.0));
        list.add(new LoaiDoAn(R.drawable.banhtrang, "Bánh tráng", 25000.0));
        list.add(new LoaiDoAn(R.drawable.buncha, "Bún chả", 83000.0));
        LoaiDoAnAdapter la = new LoaiDoAnAdapter(this, list);
        gv.setAdapter(la);
        registerForContextMenu(gv);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ThucDon.this, list.get(i).getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflatermenu = getMenuInflater();
        inflatermenu.inflate(R.menu.menu_ban_an, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int i = info.position;
        if(item.getItemId() == R.id.ban1) {
            Toast.makeText(this, "Bàn 1 chọn đặt:" + list.get(i).getTen(), Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.ban2) {
            Toast.makeText(this, "Bàn 2 chọn đặt:" + list.get(i).getTen(), Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.ban3) {
            Toast.makeText(this, "Bàn 3 chọn đặt:" + list.get(i).getTen(), Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.ban4) {
            Toast.makeText(this, "Bàn 4 chọn đặt:" + list.get(i).getTen(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}