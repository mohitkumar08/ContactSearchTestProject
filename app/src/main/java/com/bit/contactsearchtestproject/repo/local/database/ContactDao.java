package com.bit.contactsearchtestproject.repo.local.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.bit.contactsearchtestproject.repo.local.database.model.Contact;
import com.bit.contactsearchtestproject.repo.local.database.model.SearchRecordData;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact contact);

    @Query("SELECT ContactId FROM Contact ")
    Maybe<List<String>> getAllContacts();

    @Query("SELECT Contact.StagingId,Extensions.Context,Account.Status,Account.UserId FROM Contact " +
            "INNER JOIN Extensions ON Contact._id = Extensions.phoneContactId\n" +
            "INNER JOIN Account ON Extensions.context = Account.context\n" +
            "WHERE Contact.ContactId=:contactId")
    Maybe<SearchRecordData> getSearchResult(String contactId);
}
