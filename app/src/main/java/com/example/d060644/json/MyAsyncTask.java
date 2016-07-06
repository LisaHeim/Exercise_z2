package com.example.d060644.json;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by D060644 on 7/4/2016.
 */
public class MyAsyncTask extends AsyncTask<String,Integer,String> {



    public MyAdapter mmyAdapter;
    public MainActivity mmainActivity;


    public MyAsyncTask(MyAdapter amyAdapter, MainActivity aMainActivity) {

       mmyAdapter = amyAdapter;
        mmainActivity = aMainActivity;
    }

    protected String doInBackground(String... params) {
        String precontent="";
        String content="";
        for (String s : params) {
            System.out.println("do in Background " +s);
            try {
                URL url=new URL(s);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String out=null;
                while ( (out=reader.readLine())!=null) {

                    content=content+out+"\n";
                    System.out.println(out);
                }

                JSONArray jsonArray = new JSONArray(content);


                content="";
                for(int i = 0; i<jsonArray.length();i++) {
                    JSONObject tweet = jsonArray.getJSONObject(i);
                    mmainActivity.mDatastructure.add(new Tweet(tweet.getString("Vorname"), tweet.getString("Nachname"), tweet.getString("Geburtsdatum")));
                }



//                for(int i = 0; i<jsonArray.length();i++){
//
//                    JSONObject tweet = jsonArray.getJSONObject(i);
//
//                    JSONObject entities = tweet.getJSONObject("entities");
//                    JSONArray userMentions = null;
//                    boolean hasUserMentions = false;
//                    if(entities.has("user_mentions")) {
//                        userMentions = entities.getJSONArray("user_mentions");
//                        hasUserMentions = true;
//                    }
//                    if(hasUserMentions && userMentions.length() != 0) {
//                        mmainActivity.mDatastructure.add(new Tweet(tweet.getString("text"), tweet.getString("created_at"), userMentions.getJSONObject(0).getString("screen_name")));
//                    }
//                    else {
//                        mmainActivity.mDatastructure.add(new Tweet(tweet.getString("text"), tweet.getString("created_at"), "noValue"));
//                    }
//                }
//                for (int i=0; i < jsonArray.length();i++){
//
//                    JSONObject tweet = jsonArray.getJSONObject(i);
//
//if (tweet.getJSONObject("entities").has("user_mentions")) {
//    mmainActivity.mDatastructure.add(new Tweet(tweet.getString("text"), tweet.getString("created_at"), tweet.getJSONObject("entities").getJSONArray("user_mentions").getJSONObject(0).getString("screen_name")));
//
//}else{
//
//    mmainActivity.mDatastructure.add(new Tweet(tweet.getString("text"), tweet.getString("created_at"),"none"));
//
//}
//                }

            } catch (IOException e) {
                content=e.getMessage();
                System.out.println(e.getLocalizedMessage());
            } catch (SecurityException e)
            {
                content=e.getMessage();
                System.out.println(e.getLocalizedMessage());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    protected void onPostExecute(String aString) {

        mmyAdapter.notifyDataSetChanged();




    }



}