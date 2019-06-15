package com.bit.contactsearchtestproject.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bit.contactsearchtestproject.BaseApplication;
import com.bit.contactsearchtestproject.repo.local.database.AppDatabase;
import com.bit.contactsearchtestproject.repo.local.database.ContactDao;
import com.bit.contactsearchtestproject.repo.local.database.model.Account;
import com.bit.contactsearchtestproject.repo.local.database.model.SearchRecordData;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> listAccountsData = new MutableLiveData();
    private MutableLiveData<SearchRecordData> accountsSearchResultData = new MutableLiveData();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private AppDatabase appDatabase;
    private ContactDao contactDao;

    public MainViewModel(@NonNull final Application application) {
        super(application);
        appDatabase = BaseApplication.getAppDatabaseContext();
        contactDao = appDatabase.getContactDao();
    }


    void getAllAccounts() {
        contactDao.getAllContacts().subscribeOn(Schedulers.io()).subscribe(new MaybeObserver<List<String>>() {
            List<String> list;

            @Override
            public void onSubscribe(final Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(final List<String> strings) {
                list = strings;
                listAccountsData.postValue(list);
            }

            @Override
            public void onError(final Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }


    void searchContact(String contactId) {

        contactDao.getSearchResult(contactId).subscribeOn(Schedulers.io()).subscribe(new MaybeObserver<SearchRecordData>() {
            @Override
            public void onSubscribe(final Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(final SearchRecordData searchRecordData) {
                accountsSearchResultData.postValue(searchRecordData);

            }

            @Override
            public void onError(final Throwable e) {
            }

            @Override
            public void onComplete() {
                accountsSearchResultData.postValue(null);
            }
        });

    }

    public MutableLiveData<List<String>> getListAccountsData() {
        return listAccountsData;
    }

    public MutableLiveData<SearchRecordData> getSearchResultData() {
        return accountsSearchResultData;
    }
}
