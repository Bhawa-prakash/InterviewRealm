package com.e.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button addEmployeeBtn, showAllEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEmployeeBtn = findViewById(R.id.addEmployee);
        showAllEmployee = findViewById(R.id.showAllEmployee);

        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddEmployeeActivity.class);
                startActivity(i);



            }
        });
        showAllEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ShowEmployeeActivity.class);
                startActivity(i);



            }
        });


    }
}
