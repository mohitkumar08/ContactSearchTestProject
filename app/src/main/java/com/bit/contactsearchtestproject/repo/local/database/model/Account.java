package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public long accountId;

    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "userId")
    private String userId;
    @ColumnInfo(name = "context")
    private String context;

    public Account() {

    }

    public Account(final int status, final String userID, final String context) {
        this.status = status;
        this.userId= userID;
        this.context = context;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

}
