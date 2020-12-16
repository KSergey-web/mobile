package com.example.mobilepo.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilepo.BR;
import com.example.mobilepo.model.Expression;
import com.example.mobilepo.model.Repository;
import com.example.mobilepo.model.services.Operations;
import com.example.mobilepo.R;

import java.util.ArrayList;

public class MainActivityVM extends BaseObservable {
    @Bindable
    public MutableLiveData<String> number1 = new MutableLiveData<>();

    @Bindable
    public MutableLiveData<String> number2 = new MutableLiveData<>();

    @Bindable
    public MutableLiveData<String> operation = new MutableLiveData<>();

    @Bindable
    public MutableLiveData<String> result = new MutableLiveData();

    public Expression ex;
    public Context ctx;
    public Repository repo;

    private SharedPreferences preferences = null;

    public MainActivityVM() {
        repo = new Repository(ctx);
    }

    public MainActivityVM(Context context, Expression expression, SharedPreferences sp) {
        this.ex = expression;
        this.ctx = context;
        this.preferences = sp;
        repo = new Repository(context);
        result.setValue("RESULT_FRAG_!");
    }


    public void onClickeSum(){
        String num1 = number1.getValue();
        String num2 = number2.getValue();
        String res = Operations.sum(num1,num2);
        ex = new Expression(num1, num2, "+" ,res);
        repo.addNote(ex);
        this.result.setValue(res);
        notifyView();
        Toast.makeText(ctx, res, Toast.LENGTH_LONG).show();
    }

    public void onClickeMult(){
        String num1 = number1.getValue();
        String num2 = number2.getValue();
        String res = Operations.mult(num1,num2);
        ex = new Expression(num1, num2, "*" ,res);
        repo.addNote(ex);
        this.result.setValue(res);
        notifyView();
        Toast.makeText(ctx, res, Toast.LENGTH_LONG).show();
    }

    private void notifyView(){
        notifyPropertyChanged(BR.number1);
        notifyPropertyChanged(BR.number2);
        notifyPropertyChanged(BR.result);
    }

    public ArrayList<Expression> getExpressions(){
        return repo.getNotes();
    }

    public void loadData(String fragmentNum){
        Expression ex =  repo.loadNoteFromSharedPreferences(preferences, fragmentNum);
        setViewFields(ex);
    }

    private void setViewFields(Expression ex){
        this.number1.setValue(ex.getNumber1());
        this.number2.setValue(ex.getNumber2());
        this.result.setValue(ex.getResult());
        notifyView();
    }


    public void saveData(String fragmentNum){
        repo.saveNote2SharedPreferences(new Expression(number1.getValue(), number2.getValue(), result.getValue()), preferences, fragmentNum);
    }
}
