package com.example.myapplication;

import static com.example.myapplication.R.id.button_registration;
import static com.example.myapplication.R.id.company;
import static com.example.myapplication.R.id.person;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class custommer_parts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custommer_parts);
        Button button_1 = findViewById(person);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b1= new Intent(custommer_parts.this, Registration_Physical.class);
                startActivity(intent_b1);
            }
        });

        Button button_2 = findViewById(company);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_b2 = new Intent(custommer_parts.this, RegistrationActivity.class);
                startActivity(intent_b2);
            }
        });
    }
}