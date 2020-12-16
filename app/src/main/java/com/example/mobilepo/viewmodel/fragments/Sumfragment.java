package com.example.mobilepo.viewmodel.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilepo.R;
import com.example.mobilepo.databinding.FragmentSumfragmentBinding;
import com.example.mobilepo.model.Expression;
import com.example.mobilepo.viewmodel.MainActivityVM;


public class Sumfragment extends Fragment {

    public Sumfragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private MainActivityVM vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSumfragmentBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sumfragment, null, false);
        View view = fragmentBinding.getRoot();
        vm = new MainActivityVM(getActivity(), new Expression(), getActivity().getPreferences(Context.MODE_PRIVATE));
        vm.loadData("1");
        fragmentBinding.setVm(vm);
        inflater.inflate(R.layout.fragment_sumfragment,container, false);
        return view;
    }

    @Override
    public void onPause() {
        vm.saveData("1");
        super.onPause();
    }
}