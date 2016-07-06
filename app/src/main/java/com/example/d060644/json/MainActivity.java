package com.example.d060644.json;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String name;
    ArrayList<Tweet> mDatastructure;
    MyAdapter myAdapter;
    Handler h = new Handler();
    String url ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatastructure = new ArrayList<Tweet>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myrecview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(mDatastructure);
        recyclerView.setAdapter(myAdapter);




    }



    public class PollingClass extends MainActivity implements Runnable {


        public void run() {


            h.postDelayed(this, 1000);
            url = ("http://webtechlecture.appspot.com/personen/list");
            MyAsyncTask task = new MyAsyncTask(myAdapter, this);
            task.execute(url);
//            myAdapter.notifyDataSetChanged();

        }

    }


    public void click(View aView) {

        mDatastructure.clear();
     url = ("http://webtechlecture.appspot.com/personen/list");

        MyAsyncTask task = new MyAsyncTask(myAdapter, this);
        task.execute(url);

        // h.post(new PollingClass());
    }

    public void dosth (){

        h.post(new PollingClass());
    }


}



//    public void dosth (int position){
//
//        Tweet aTweet = mDatastructure.get(position);
//        String name = aTweet.mUserMentions;
//        mDatastructure.clear();
//        EditText et_name = (EditText) findViewById(R.id.editText3);
//        et_name.setText(name);
//        String url = ("http://webtechlecture.appspot.com/timeline?screenname="+name);
//        MyAsyncTask task=new MyAsyncTask(myAdapter, this);
//        task.execute(url);
//
//
//
//
////
//
////        Intent i= new Intent (this, MainActivity2.class);
////        startActivity(i);
//
//
//
//
//    }




