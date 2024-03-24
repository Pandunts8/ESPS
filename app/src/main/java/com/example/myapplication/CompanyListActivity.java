package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CompanyListActivity extends AppCompatActivity {

    private ListView listViewCompanies;
    private List<Company> companies;
    private DatabaseReference databaseCompanies;
    private CompanyAdapter adapter;
    private EditText editTextCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        listViewCompanies = findViewById(R.id.listViewCompanies);
        companies = new ArrayList<>();
        adapter = new CompanyAdapter(this, companies);
        listViewCompanies.setAdapter(adapter);
        databaseCompanies = FirebaseDatabase.getInstance().getReference("companies");


        // Read from the database
        readDataFromDatabase();
    }

    private void readDataFromDatabase() {
        // Attach a listener to read the data at our companies reference
        databaseCompanies.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                companies.clear();
                for (DataSnapshot companySnapshot : dataSnapshot.getChildren()) {
                    Company company = companySnapshot.getValue(Company.class);
                    companies.add(company);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("CompanyListActivity", "loadCompany:onCancelled", databaseError.toException());
                Toast.makeText(CompanyListActivity.this, "Failed to load companies.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addNewCompany() {
        String companyName = editTextCompanyName.getText().toString().trim();
        if (!companyName.isEmpty()) {
            String id = databaseCompanies.push().getKey();
            Company newCompany = new Company(id, companyName);
            databaseCompanies.child(id).setValue(newCompany).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(CompanyListActivity.this, "Company added", Toast.LENGTH_SHORT).show();
                    editTextCompanyName.setText("");
                } else {
                    Toast.makeText(CompanyListActivity.this, "Failed to add company", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Please enter a company name", Toast.LENGTH_SHORT).show();
        }
    }
}
