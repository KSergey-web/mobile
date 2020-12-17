package com.example.mobilepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mobilepo.databinding.ActivityChangeFragmentsBinding;
import com.example.mobilepo.databinding.ActivityOpenLinkBinding;
import com.example.mobilepo.viewmodel.ChangeFragmentsActivityVM;
import com.example.mobilepo.viewmodel.OpenLinkVM;
import com.example.mobilepo.viewmodel.fragments.Multfragment;
import com.example.mobilepo.viewmodel.fragments.Sumfragment;

public class ChangeFragmentsActivity extends AppCompatActivity {

    private ChangeFragmentsActivityVM changeFragmentsActivityVM;
    private ActivityChangeFragmentsBinding activityChangeFragmentsBinding;
    Boolean ismult;
    Multfragment mult;
    Sumfragment sum;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_fragments);
        mult = new Multfragment();
        sum = new Sumfragment();
        ismult = true;
        activityChangeFragmentsBinding = DataBindingUtil.setContentView(this, R.layout.activity_change_fragments);
        changeFragmentsActivityVM = new ChangeFragmentsActivityVM(this);
        activityChangeFragmentsBinding.setVm(changeFragmentsActivityVM);
    }

    private  void showMult(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, mult);
        transaction.commit();
    }

    private  void showSum(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, sum);
        transaction.commit();
    }

    public void onClickChangefr() {
        if(ismult) showSum();
        else showMult();
        ismult = !ismult;
    }
}