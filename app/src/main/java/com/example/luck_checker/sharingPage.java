package com.example.luck_checker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class sharingPage extends AppCompatActivity {
    TextView t1;
    Button  bb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sharing_page);
        t1=findViewById(R.id.tt1);
        bb1=findViewById(R.id.btn1);
        Intent i=getIntent();
        String name=i.getStringExtra("Name");
        int ii=new Random().nextInt(1000);
        t1.setText("Welcome "+name+" your lucky numer is "+ii);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareluck(name,ii);
            }
        });
    }
    public void shareluck(String i,int ii){
          Intent oi=new Intent(Intent.ACTION_SEND);
          oi.setType("Text/plain");
          oi.putExtra(Intent.EXTRA_USER,i);
          oi.putExtra(Intent.EXTRA_TEXT,ii);
          startActivity(Intent.createChooser(oi,"choose the platfrom"));

    }
}