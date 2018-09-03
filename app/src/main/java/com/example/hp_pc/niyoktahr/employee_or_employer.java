package com.example.hp_pc.niyoktahr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp_pc.niyoktahr.employer_fragment.Employer_detail;
import com.example.hp_pc.niyoktahr.fragments.Fill_details;

public class employee_or_employer extends AppCompatActivity {
    Button employee;
    Button employer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_or_employer);
        employee=(Button)findViewById(R.id.btemployee);
        employer=(Button)findViewById(R.id.btemployer);
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(employee_or_employer.this,Fill_details.class));
            }
        });
        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(employee_or_employer.this,Employer_detail.class));
            }
        });
    }
}
