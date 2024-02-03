package com.example.myapplication;

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

        Button button_1 = findViewById(R.id.triangle_button1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b1 = new Intent(activity_work.this, triangle_button1.class);
                startActivity(intent_b1);
            }



        });
        Button button_2 = findViewById(R.id.triangle_button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b2 = new Intent(activity_work.this, triangle_button1.class);
                startActivity(intent_b2);
            }
        });
    }
}