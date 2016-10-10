package com.mishrafamily.sjbook;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.FirebaseRecyclerAdapter;


public class ShowEvent extends AppCompatActivity {
    Firebase mref;
    ListView listViewShowEvent;
    //String url = "https://sjbook-b02b6.firebaseio.com/Information Technology";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);
        Firebase.setAndroidContext(this);
        listViewShowEvent =(ListView)findViewById(R.id.listViewShowEvent);
        //--------------------------------------------------------------------------------


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
        //createMenu(menu);
        //ToDo:Create overflow menu form the book.

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        //selectItem(item);
        //TODO:create class to handle the events
    }

    @Override
    protected void onStart() {
        super.onStart();

       mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Civil");
       FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(
                this,
                String.class,
                android.R.layout.two_line_list_item,
                mref
        ) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView =(TextView)view.findViewById(android.R.id.text1);
                textView.setText(s);

            }
        };
        listViewShowEvent.setAdapter(firebaseListAdapter);
      //TODO:add filtering capability from the book









    }



}




