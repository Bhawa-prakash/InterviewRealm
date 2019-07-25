package com.e.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button addEmployeeBtn, showAllEmployee;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEmployeeBtn = findViewById(R.id.addEmployee);
        showAllEmployee = findViewById(R.id.showAllEmployee);
        linearLayout = findViewById(R.id.linearlayout);

        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAllEmployee.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                Intent i = new Intent(MainActivity.this, AddEmployeeActivity.class);
                startActivity(i);


            }
        });


        showAllEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowEmployeeActivity.class);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                addEmployeeBtn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                startActivity(i);


            }
        });


    }
}
