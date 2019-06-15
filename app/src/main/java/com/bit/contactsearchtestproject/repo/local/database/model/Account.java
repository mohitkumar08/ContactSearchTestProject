package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public long accountId;

    @ColumnInfo(name = "Status")
    private int status;

    @ColumnInfo(name = "UserId")
    private String userID;
    @ColumnInfo(name = "Context")
    private String context;


    public Account(final int status, final String userID, final String context) {
        this.status = status;
        this.userID = userID;
        this.context = context;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(final String userID) {
        this.userID = userID;
    }

    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

}
