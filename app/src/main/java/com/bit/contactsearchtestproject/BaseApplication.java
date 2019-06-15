package com.bit.contactsearchtestproject;

import android.app.Application;

import com.bit.contactsearchtestproject.repo.local.database.AppDatabase;

public class BaseApplication extends Application {
    private static AppDatabase appDatabaseContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabaseContext = AppDatabase.getInstance(this);
        Utility.insertDummyData();
    }

    public static AppDatabase getAppDatabaseContext() {
        return appDatabaseContext;
    }
}
