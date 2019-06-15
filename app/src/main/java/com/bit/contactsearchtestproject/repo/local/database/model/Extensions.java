package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Extensions")
public class Extensions {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public long extensionId;

    @NonNull
    @ColumnInfo(name = "context")
    private String context;

    @ColumnInfo(name = "phoneContactId")
    private int phoneContactId;

    public Extensions(final String context, final int phoneContactId) {
        this.context = context;
        this.phoneContactId = phoneContactId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    public int getPhoneContactId() {
        return phoneContactId;
    }

    public void setPhoneContactId(final int phoneContactId) {
        this.phoneContactId = phoneContactId;
    }

}
