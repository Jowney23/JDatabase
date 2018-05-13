package com.jowney.database;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jowney.database.bean.Student;
import com.jowney.database.bean.manager.StudentManager;
import com.jowney.database.dao.DaoManager;

public class MainActivity extends AppCompatActivity {
    StudentManager studentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentManager = new StudentManager(DaoManager.getInstance(MyApp.getContext()).getDaoSession().getStudentDao());

    }
}
