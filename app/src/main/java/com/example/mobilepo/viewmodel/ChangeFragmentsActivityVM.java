package com.example.mobilepo.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;

import com.example.mobilepo.ChangeFragmentsActivity;


public class ChangeFragmentsActivityVM extends BaseObservable {
    public Context ctx;


    public ChangeFragmentsActivityVM(Context context) {
        this.ctx = context;
    }

    public void onClickChange() {
        ((ChangeFragmentsActivity)ctx).onClickChangefr();
    }
}
