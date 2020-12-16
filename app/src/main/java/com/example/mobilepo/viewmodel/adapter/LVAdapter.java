package com.example.mobilepo.viewmodel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilepo.R;
import com.example.mobilepo.model.Expression;

import java.util.ArrayList;

public class LVAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater linf;
    ArrayList<Expression> list;

    public LVAdapter(Context ctx, ArrayList<Expression> list) {
        this.ctx = ctx;
        this.linf = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view1, ViewGroup viewGroup) {
        View view = view1;
        if(view == null){
            view = linf.inflate(R.layout.list_item, viewGroup, false);
        }
        final Expression ex = (Expression) getItem(i);
        final TextView num1 = (TextView) view.findViewById(R.id.item_number1);
        num1.setText(ex.getNumber1());
        final TextView num2 =(TextView) view.findViewById(R.id.item_number2);
        num2.setText(ex.getNumber2());
        final TextView oper =(TextView) view.findViewById(R.id.item_operation);
        oper.setText(ex.getOperation());
        final TextView res =(TextView) view.findViewById(R.id.item_result);
        res.setText(ex.getResult());
        return  view;
    }
}
