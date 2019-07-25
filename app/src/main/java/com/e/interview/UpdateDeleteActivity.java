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
        final String email = bundle.getString("Email");

        addressUp.setText(address);
        nameUp.setText(name);
        phoneNoUp.setText(phone);
        emailUp.setText(email);

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                deleteUser();
            }
        });

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                updateDetail();
            }

            private void updateDetail() {

                Realm realm = Realm.getDefaultInstance();

                RealmResults<Employee> results = realm.where(Employee.class).equalTo("email", email).findAll();
                final String userName = nameUp.getText().toString().trim();
                final String userAddress = addressUp.getText().toString().trim();
                final String userPhone = phoneNoUp.getText().toString().trim();

                if (results != null && results.size() > 0) {
                    final Employee employee = results.first();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                employee.setName(userName);
                                employee.setAddress(userAddress);
                                employee.setPhoneno(userPhone);
                                Toast.makeText(UpdateDeleteActivity.this, "update Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    } catch (Exception e) {
                        Toast.makeText(UpdateDeleteActivity.this, "Unable to Update", Toast.LENGTH_SHORT).show();

                    }

                }


            }
        });


    }

    public void deleteUser() {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                String userEmail = emailUp.getText().toString().trim();
                RealmResults<Employee> rows = realm.where(Employee.class).equalTo("email", userEmail).findAll();
                rows.deleteAllFromRealm();
                startActivity(new Intent(UpdateDeleteActivity.this, MainActivity.class));
                Toast.makeText(UpdateDeleteActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
