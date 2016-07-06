package com.example.d060644.json;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by D060644 on 7/5/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView tv_firstname;
    TextView tv_lastname;
    TextView tv_birthday;


    public MyViewHolder (View cnew){

        super (cnew);
        tv_firstname = (TextView) cnew.findViewById(R.id.tv_firstname);
        tv_lastname = (TextView) cnew.findViewById(R.id.tv_lastname);
        tv_birthday = (TextView) cnew.findViewById(R.id.tv_birthday);

        cnew.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       MainActivity mainActivity = (MainActivity) v.getContext();
        mainActivity.dosth();



    }



}