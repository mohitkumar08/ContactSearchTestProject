package com.bit.contactsearchtestproject.repo.local.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PokemonTable")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int _id;

    @ColumnInfo(name = "ContactId")
    private String contactId;

    @ColumnInfo(name = "StagingId")
    private String stagingId;

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
