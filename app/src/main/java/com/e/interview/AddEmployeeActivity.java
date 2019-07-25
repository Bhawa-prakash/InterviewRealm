package com.e.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.interview.model.Employee;

import io.realm.Realm;


public class AddEmployeeActivity extends AppCompatActivity {
    private EditText namee, emaill, phonNo, addres;
    private Button addUser;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        namee = findViewById(R.id.name);
        emaill = findViewById(R.id.email);
        addres = findViewById(R.id.address);
        phonNo = findViewById(R.id.phone);
        addUser = findViewById(R.id.adduser);
        realm  = Realm.getDefaultInstance();

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Employee employee = new Employee();
                employee.setName(namee.getText().toString());
                employee.setAddress(addres.getText().toString());
                employee.setPhoneno(phonNo.getText().toString());
                employee.setEmail(emaill.getText().toString());
                realm.copyToRealmOrUpdate(employee);
                realm.commitTransaction();
                Toast.makeText(AddEmployeeActivity.this, "add user successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
