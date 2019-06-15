package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Accounts", foreignKeys = @ForeignKey(entity = Extensions.class,
        parentColumns = "Context",
        childColumns = "Context"))
public class Accounts {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int _id;

    @ColumnInfo(name = "Status")
    private String status;

    @ColumnInfo(name = "UserId")
    private String userID;
    @ColumnInfo(name = "Context")
    private String context;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
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
