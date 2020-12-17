package com.example.mobilepo.viewmodel.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilepo.MainActivity;
import com.example.mobilepo.R;
import com.example.mobilepo.databinding.FragmentMultfragmentBinding;
import com.example.mobilepo.databinding.FragmentSumfragmentBinding;
import com.example.mobilepo.model.Expression;
import com.example.mobilepo.viewmodel.MainActivityVM;


public class Multfragment extends Fragment {


    public Multfragment() {
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
        FragmentMultfragmentBinding fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_multfragment, null, false);
        View view = fragmentBinding.getRoot();
        vm = new MainActivityVM(getActivity(), new Expression(), getActivity().getPreferences(Context.MODE_PRIVATE));
        vm.loadData("1");
        fragmentBinding.setVm(vm);
        inflater.inflate(R.layout.fragment_multfragment,container, false);
        return view;
    }

    @Override
    public void  onDestroy() {
        vm.saveData("1");
        super.onDestroy();
    }
}