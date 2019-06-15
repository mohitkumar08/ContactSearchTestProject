package com.bit.contactsearchtestproject;

import com.bit.contactsearchtestproject.repo.local.database.AccountDao;
import com.bit.contactsearchtestproject.repo.local.database.AppDatabase;
import com.bit.contactsearchtestproject.repo.local.database.ContactDao;
import com.bit.contactsearchtestproject.repo.local.database.ExtensionsDao;
import com.bit.contactsearchtestproject.repo.local.database.model.Account;
import com.bit.contactsearchtestproject.repo.local.database.model.Contact;
import com.bit.contactsearchtestproject.repo.local.database.model.Extensions;

public class Utility {

    public static void insertDummyData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase appDatabase=BaseApplication.getAppDatabaseContext();

                ContactDao contactDao=appDatabase.getContactDao();
                ExtensionsDao extensionDao=appDatabase.getExtensionDao();
                AccountDao accountDao=appDatabase.getAccountDao();

                Contact contact;
                Extensions extension;
                Account account;

                contact=new Contact(2, "48f3", "1196");
                contactDao.insertContact(contact);

                extension=new Extensions("Gmail",2);
                extensionDao.insertExtensions(extension);

                account=new Account(1,"test_one@gmail.com","Gmail");
                accountDao.insertAccount(account);


                contact=new Contact(3, "3e47", "f1fe");
                contactDao.insertContact(contact);

                extension=new Extensions("Gmail1",3);
                extensionDao.insertExtensions(extension);

                account=new Account(2,"test_11one@gmail.com","yahoo");
                accountDao.insertAccount(account);


                contact=new Contact(4, "2cac", "036e");
                contactDao.insertContact(contact);

                extension=new Extensions("Hotmail",4);
                extensionDao.insertExtensions(extension);

                account=new Account(2,"test_12one@gmail.com","Hotmail");
                accountDao.insertAccount(account);


            }
        }).start();


    }



}
