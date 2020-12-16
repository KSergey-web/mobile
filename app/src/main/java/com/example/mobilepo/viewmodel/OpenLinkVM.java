package com.example.mobilepo.viewmodel;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilepo.OpenLinkActivity;
import com.example.mobilepo.R;
import com.example.mobilepo.model.Repository;

public class OpenLinkVM extends BaseObservable {

    @Bindable
    public MutableLiveData<String> link = new MutableLiveData<>();

    public Context ctx;
    public Repository repo;

    public OpenLinkVM(Context context, String query) {
        this.ctx = context;
        repo = new Repository(context);
        link.setValue(query);
    }

    public void onClickOpenLink() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, link.getValue().toString());
        ctx.startActivity(intent);
    }

    public void saveTimer(String str) {
        repo.saveTotalCount(str);
    }

    public void onStartTimer() {
        ((OpenLinkActivity)ctx).startService();
    }

    public void onStopTimer() {
        ((OpenLinkActivity)ctx).stopService();
    }
}