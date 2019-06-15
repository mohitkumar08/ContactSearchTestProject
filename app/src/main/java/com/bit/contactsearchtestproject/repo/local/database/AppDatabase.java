package com.bit.contactsearchtestproject.repo.local.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bit.contactsearchtestproject.repo.local.database.model.Account;
import com.bit.contactsearchtestproject.repo.local.database.model.Contact;
import com.bit.contactsearchtestproject.repo.local.database.model.Extensions;


@Database(entities = {Contact.class,Account.class,Extensions.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "AppDb";
    private static volatile AppDatabase sInstance;

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                    }
                }).build();
    }


    public abstract ContactDao getContactDao();
    public abstract AccountDao getAccountDao();
    public abstract ExtensionsDao getExtensionDao();


}