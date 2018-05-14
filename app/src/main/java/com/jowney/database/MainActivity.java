package com.jowney.database;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jowney.database.bean.Student;
import com.jowney.database.bean.manager.ManagerFactory;
import com.jowney.database.bean.manager.StudentManager;
import com.jowney.database.dao.DaoManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String tag = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
