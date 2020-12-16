package com.example.mobilepo.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.mobilepo.model.files.TxtFile;
import com.example.mobilepo.model.interfaces.IDao;
import com.example.mobilepo.model.room.DB;
import com.example.mobilepo.model.room.Note;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private IDao iDao;
    private MutableLiveData<List<Note>> allNotes;
    private static DB db = null;
    private Context ctx;


    private TxtFile txtFile;

    public Repository(Context context){
        txtFile = new TxtFile(context);
        if(db != null) return;
        db = Room.databaseBuilder(context.getApplicationContext(),
                DB.class, "notedb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        ctx = context;
    }

    public void addNote(Expression ex){
         db.Dao().insert(new Note(ex.getNumber1(), ex.getNumber2(), ex.getOperation(), ex.getResult()));
    }

    public ArrayList<Expression> getNotes(){
        List<Note> notes =  db.Dao().getAllNotes();
        ArrayList<Expression> expressions = new ArrayList<>();
        for(Note n : notes){
            expressions.add(new Expression(n.getNumber1(), n.getNumber2(), n.getOperation(),n.getResult()));
        }
        return  expressions;
    }

    public void saveResult(String str){
        txtFile.write(str);
    }

    public String getResult(){
        return txtFile.read();
    }

    public void saveNote2SharedPreferences(Expression ex, SharedPreferences sp, String postfix){
        if(sp == null) return;
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("number1" + postfix, ex.getNumber1());
        editor.putString("number2" + postfix, ex.getNumber2());
        editor.putString("operation" + postfix, ex.getOperation());
        editor.putString("result" + postfix, ex.getResult());
        editor.commit();
    }

    public Expression loadNoteFromSharedPreferences(SharedPreferences sp, String postfix){
        if(sp == null) return  new Expression();
        Expression ex = new Expression(
                sp.getString("number1" + postfix, ""),
                sp.getString("number2" + postfix, ""),
                sp.getString("operation" + postfix, ""),
                sp.getString("result" + postfix, "")
        );
        return  ex;
    }

    public void removeAllNotes(){  db.Dao().deleteAllNotes(); }

    public void saveTotalCount(String s){
        Log.d("COUNT_TEST_SAVI", s);
        txtFile.write(s);
    }

    public String getTotalCount(){
        Log.d("COUNT_TEST_SAVI2", "f");
        return txtFile.read();
    }
}
