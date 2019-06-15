package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ExtensionTable", foreignKeys = @ForeignKey(entity = Contact.class,
        parentColumns = "_id",
        childColumns = "PhoneContactId"))
public class Extensions {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int _id;
    @ColumnInfo(name = "Context")
    private String context;

    @ColumnInfo(name = "PhoneContactId")
    private String phoneContactId;

    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    public String getPhoneContactId() {
        return phoneContactId;
    }

    public void setPhoneContactId(final String phoneContactId) {
        this.phoneContactId = phoneContactId;
    }
}
