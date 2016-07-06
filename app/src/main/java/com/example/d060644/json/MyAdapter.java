package com.example.d060644.json;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by D060644 on 7/5/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public ArrayList<Tweet> mDatastructure;

    public MyAdapter (ArrayList<Tweet> aDatastructure){
        mDatastructure=aDatastructure;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup layoutManager, int viewType){
        LayoutInflater inflater = LayoutInflater.from(layoutManager.getContext());
        View myCardView = inflater.inflate(R.layout.mycontent, layoutManager, false );
        return new MyViewHolder(myCardView);
    }

    @Override
    public void onBindViewHolder (MyViewHolder myViewHolder, int position){
        Tweet t = mDatastructure.get(position);

        myViewHolder.tv_firstname.setText(t.mFirstName);
        myViewHolder.tv_lastname.setText(t.mLastName);
        myViewHolder.tv_birthday.setText(t.mBirthday);


    }


    @Override
    public int getItemCount(){
        return mDatastructure.size();
    }



}

