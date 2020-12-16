package com.example.mobilepo.model;

public class Expression {
    private String number1 = "";
    private String number2 = "";
    private String operation = "";
    private String result = "";

    public Expression() {
    }

    public Expression(String number1, String number2, String operation,String result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public Expression(String number1, String number2, String result) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
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
