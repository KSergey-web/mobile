package com.example.mobilepo.model.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expressions")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "number1")
    private String number1;

    @ColumnInfo(name = "number2")
    private String number2;

    @ColumnInfo(name = "operation")
    private String operation;

    @ColumnInfo(name = "result")
    private String result;

    public Note(String number1, String number2, String operation, String result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNumber1()  {
        return number1;
    }

    public String getNumber2()  {
        return number2;
    }

    public String getOperation()  {
        return operation;
    }

    public String getResult()  {
        return result;
    }
}