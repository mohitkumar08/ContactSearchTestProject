package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;

public class SearchRecordData {
    @ColumnInfo(name = "status")
    private int status;
    @ColumnInfo(name = "stagingId")
    private String staging;
    @ColumnInfo(name = "userId")
    private String userId;
    @ColumnInfo(name = "context")
    private String context;

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getStaging() {
        return staging;
    }

    public void setStaging(final String staging) {
        this.staging = staging;
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
