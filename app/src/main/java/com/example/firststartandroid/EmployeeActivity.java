package com.example.firststartandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeActivity extends AppCompatActivity {

    private EmployeeSharePreference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee); // Create this XML layout

        preference = new EmployeeSharePreference(this);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnGet = findViewById(R.id.btnGet);
        Button btnRemove = findViewById(R.id.btnRemove);

        btnSave.setOnClickListener(v -> {
            Employee emp = new Employee("E001", "Mesa", "Official", "BBU Phnom Penh",
                    400.0, "2001-02-02", "0123456789", "Active");
            preference.save(emp);
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        });

        btnGet.setOnClickListener(v -> {
            Employee emp = preference.get();
            if (emp != null) {
                Toast.makeText(this, "Employee: " + emp.getFirstName() + " " + emp.getLastName(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No employee saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(v -> {
            preference.remove();
            Toast.makeText(this, "Removed!", Toast.LENGTH_SHORT).show();
        });
    }
}
