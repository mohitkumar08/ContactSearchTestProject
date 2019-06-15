package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Contact")
public class Contact {
    @NonNull
    @PrimaryKey
    @ColumnInfo
    private int _id;

    @ColumnInfo(name = "contactId")
    private String contactId;

    @ColumnInfo(name = "stagingId")
    private String stagingId;

    public Contact(final int _id, final String contactId, final String stagingId) {
        this._id = _id;
        this.contactId = contactId;
        this.stagingId = stagingId;
    }

    public int get_id() {
        return _id;
    }


    public String getContactId() {
        return contactId;
    }

    public void setContactId(final String contactId) {
        this.contactId = contactId;
    }

    public String getStagingId() {
        return stagingId;
    }

    public void setStagingId(final String stagingId) {
        this.stagingId = stagingId;
    }
}
