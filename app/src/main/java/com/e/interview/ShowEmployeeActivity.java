package com.e.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.e.interview.adapter.EmployeeAdapter;
import com.e.interview.model.Employee;

import java.util.List;

public class ShowEmployeeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);
        recyclerView = findViewById(R.id.recycler);
        employeeList = Employee.getAllEmployee();

        if (employeeList != null && employeeList.size() > 0) {

            EmployeeAdapter employeeAdapter = new EmployeeAdapter(this,employeeList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(employeeAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        } else {

            recyclerView.setVisibility(View.GONE);
        }


    }
}
