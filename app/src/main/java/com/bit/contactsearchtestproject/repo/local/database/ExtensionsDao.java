package com.bit.contactsearchtestproject.repo.local.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import com.bit.contactsearchtestproject.repo.local.database.model.Extensions;

@Dao
public interface ExtensionsDao {

    @Insert
    void insertExtensions(Extensions extensions);

}
