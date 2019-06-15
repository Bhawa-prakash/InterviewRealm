package com.e.interview.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.interview.R;
import com.e.interview.UpdateDeleteActivity;
import com.e.interview.model.Employee;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {


    private Context context;
    private List<Employee> employeeList;


    @NonNull
    @Override
    public EmployeeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final EmployeeAdapter.MyViewHolder myViewHolder, int i) {
        Employee movie = employeeList.get(i);
        myViewHolder.empName.setText(movie.getName());
        myViewHolder.empAddress.setText(movie.getAddress());
        myViewHolder.empPhoneNoo.setText(movie.getPhoneno());
        myViewHolder.empEmail.setText(movie.getEmail());


       myViewHolder.cardView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateDeleteActivity.class);
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Name",employeeList.get(myViewHolder.getAdapterPosition()).getName());
                i.putExtra("Address",employeeList.get(myViewHolder.getAdapterPosition()).getAddress());
                i.putExtra("PhoneNo",employeeList.get(myViewHolder.getAdapterPosition()).getPhoneno());
                i.putExtra("Email",employeeList.get(myViewHolder.getAdapterPosition()).getEmail());


             context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public EmployeeAdapter(Context context,List<Employee> employeeList) {
        this.employeeList = employeeList;
        this.context =context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView empName,empAddress,empPhoneNoo,empEmail;
        private CardView cardView1;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            empName = itemView.findViewById(R.id.namer);
            empAddress = itemView.findViewById(R.id.addressr);
            empPhoneNoo = itemView.findViewById(R.id.Phonenor);
            empEmail = itemView.findViewById(R.id.emailr);
            cardView1 = itemView.findViewById(R.id.cardView);
        }
    }
}
