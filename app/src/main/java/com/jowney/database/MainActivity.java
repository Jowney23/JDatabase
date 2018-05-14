package com.jowney.database;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jowney.database.adapter.RecyclerAdapter;
import com.jowney.database.bean.Student;
import com.jowney.database.bean.manager.ManagerFactory;
import com.jowney.database.bean.manager.StudentManager;
import com.jowney.database.dao.DaoManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void save(View view) {
        for (int i = 0;i<10;i++){
            Student student = new Student(null,"周"+i,i,"年纪"+i);
            Student student1 = new Student(null,"李"+i,i,"年纪"+i);
            ManagerFactory.getInstance().getStudentManager().save(student,student1);
         //   ManagerFactory.getInstance().getStudentManager().saveOrUpdate();
        }
    }

    public void delete(View view) {
        ManagerFactory.getInstance().getStudentManager().deleteAll();
    }

    public void update(View view) {

    }

    public void query(View view) {

        RecyclerAdapter<Student> recyclerAdapter = new RecyclerAdapter<>(ManagerFactory.getInstance().getStudentManager().queryAll());
        recyclerView.setAdapter(recyclerAdapter);
    }
}
