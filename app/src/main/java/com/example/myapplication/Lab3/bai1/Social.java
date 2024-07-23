package com.example.myapplication.Lab3.bai1;

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

public class Social extends AppCompatActivity {

    private ArrayList<SocialNetwork> listSN = new ArrayList<SocialNetwork>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_social);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rbtNam), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lv = findViewById(R.id.lvSocial);
        listSN.add(new SocialNetwork(R.drawable.face, "Facebook"));
        listSN.add(new SocialNetwork(R.drawable.linkedin, "Linkedin"));
        listSN.add(new SocialNetwork(R.drawable.msn, "MSN"));
        listSN.add(new SocialNetwork(R.drawable.skype, "Skype"));
        listSN.add(new SocialNetwork(R.drawable.yahoo, "Yahoo"));
        listSN.add(new SocialNetwork(R.drawable.x, "X"));
        SocialAdapter sa = new SocialAdapter(this, listSN);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Social.this, listSN.get(i).getTen(), Toast.LENGTH_LONG).show();
            }
        });
    }
}