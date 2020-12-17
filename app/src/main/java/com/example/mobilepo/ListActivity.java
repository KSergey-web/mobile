package com.example.mobilepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mobilepo.databinding.ActivityListBinding;
import com.example.mobilepo.model.Expression;
import com.example.mobilepo.model.Repository;
import com.example.mobilepo.viewmodel.MainActivityVM;
import com.example.mobilepo.viewmodel.adapter.LVAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ActivityListBinding activityBinding;
    private MainActivityVM mainvm;
    private ArrayList<MainActivityVM> lab1VMArrayList;

    private ArrayList<Expression> lv;
    private LVAdapter adapter;
    public Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        repo = new Repository(this);
        lv = repo.getNotes();
        adapter = new LVAdapter(this, lv);
        ListView listView = findViewById(R.id.list_expressions);
        listView.setAdapter(adapter);
    }
}