package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Company;
import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellerActivity extends AppCompatActivity {

    private EditText companyNameEditText;
    private DatabaseReference databaseCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        companyNameEditText = findViewById(R.id.companyNameEditText);
        Button addCompanyButton = findViewById(R.id.addCompanyButton);
        databaseCompanies = FirebaseDatabase.getInstance().getReference("companies");

        addCompanyButton.setOnClickListener(view -> {
            addCompany();
        });
    }

    private void addCompany() {
        String name = companyNameEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            String id = databaseCompanies.push().getKey();
            Company company = new Company(id, name);
            databaseCompanies.child(id).setValue(company).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(SellerActivity.this, "Company added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SellerActivity.this, "Failed to add company", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "You must enter a company name", Toast.LENGTH_SHORT).show();
        }
    }
}
