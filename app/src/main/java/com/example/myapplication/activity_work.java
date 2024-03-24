package com.example.myapplication;

import static com.example.myapplication.R.id.button_log;
import static com.example.myapplication.R.id.button_registration;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_work extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        Button button_2 = findViewById(button_registration);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b2 = new Intent(activity_work.this, reg.class);
                startActivity(intent_b2);
            }
        });
        Button button_1 = findViewById(button_log);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b1 = new Intent(activity_work.this, Log_page.class);
                startActivity(intent_b1);
            }
            });

    }
}