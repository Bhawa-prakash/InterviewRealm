package com.e.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.e.interview.adapter.EmployeeAdapter;
import com.e.interview.model.Employee;

import java.util.List;

public class ShowEmployeeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    EditText etSearch;

    List<Employee> employeeList;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);
        recyclerView = findViewById(R.id.recycler);
        etSearch = findViewById(R.id.etSearch);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                employeeAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                employeeAdapter.getFilter().filter(s);
                

            }
        });


        employeeList = Employee.getAllEmployee();


        if (employeeList != null && employeeList.size() > 0) {

            //Add recyclerView
            employeeAdapter = new EmployeeAdapter(this, employeeList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(employeeAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        } else {

            recyclerView.setVisibility(View.GONE);
        }


    }

}
