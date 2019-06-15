package com.bit.contactsearchtestproject.repo.local.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.bit.contactsearchtestproject.repo.local.database.model.Account;

@Dao
public interface AccountDao {

    @Insert
    void insertAccount(Account account);


}
