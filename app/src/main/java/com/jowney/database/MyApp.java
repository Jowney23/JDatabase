package com.jowney.database;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import com.jowney.database.dao.DaoManager;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/13/22:46
 * Description:
 */

public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApp.context = this;
        DaoManager.getInstance(this).setDebug(true);
      //  DaoManager.getInstance(this).encryptDatabase("www");
    }

    public static Context getContext() {
        return MyApp.context;
    }

}
