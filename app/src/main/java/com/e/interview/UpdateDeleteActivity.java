package com.e.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.interview.model.Employee;

import io.realm.Realm;
import io.realm.RealmResults;

public class UpdateDeleteActivity extends AppCompatActivity {
    EditText addressUp, nameUp, phoneNoUp, emailUp;
    Button deleteUser, updateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        addressUp = findViewById(R.id.addresss);
        nameUp = findViewById(R.id.nameee);
        phoneNoUp = findViewById(R.id.phonenumbbb);
        emailUp = findViewById(R.id.emailll);
        deleteUser = findViewById(R.id.deleteUser);
        updateUser = findViewById(R.id.updateUser);


        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("Name");
        String address = bundle.getString("Address");
        String phone = bundle.getString("PhoneNo");
        String email = bundle.getString("Email");

        addressUp.setText(address);
        nameUp.setText(name);
        phoneNoUp.setText(phone);
        emailUp.setText(email);

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();
            }
        });
        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDetail();
            }

            private void updateDetail() {

                Realm realm = Realm.getDefaultInstance();


                RealmResults<Employee> results = realm.where(Employee.class).equalTo("Name", name).findAll();
                String userName = nameUp.getText().toString().trim();

                realm.beginTransaction();

                for (Employee student : results) {
                    student.setName(userName);

                }

                realm.commitTransaction();
                startActivity(new Intent(UpdateDeleteActivity.this, MainActivity.class));
                Toast.makeText(UpdateDeleteActivity.this, "update Successfully", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void deleteUser() {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                String userName = emailUp.getText().toString().trim();
                RealmResults<Employee> rows = realm.where(Employee.class).equalTo("email", userName).findAll();
                rows.deleteAllFromRealm();
                startActivity(new Intent(UpdateDeleteActivity.this, MainActivity.class));
                Toast.makeText(UpdateDeleteActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
