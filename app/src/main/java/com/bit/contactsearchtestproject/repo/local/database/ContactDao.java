package com.bit.contactsearchtestproject.repo.local.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bit.contactsearchtestproject.repo.local.database.model.Contact;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact contact);

    @Query("SELECT ContactId FROM Contact ")
    Maybe<List<String>> getAllContacts();

    @Query("SELECT * FROM Contact ")
    Maybe<Contact> searchContactDao(String contactId);
}
