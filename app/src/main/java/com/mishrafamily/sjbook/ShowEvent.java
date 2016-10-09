package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;


public class ShowEvent extends AppCompatActivity {
    Firebase mref;
    RecyclerView recyclerView;
    String url = "https://sjbook-b02b6.firebaseio.com/Events";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);
        Firebase.setAndroidContext(this);
        mref = new Firebase(url);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
       // Firebase ref = mref.child("Events");
        FirebaseRecyclerAdapter<String,EventViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<String, EventViewHolder>(
                String.class,
                android.R.layout.two_line_list_item,
                EventViewHolder.class,
                mref
        ) {
            @Override
            protected void populateViewHolder(EventViewHolder eventViewHolder, String s, int i) {
                eventViewHolder.textView.setText(s);
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

   public class EventViewHolder extends RecyclerView.ViewHolder{
       TextView textView;
       public EventViewHolder(View itemView) {
           super(itemView);
           textView=(TextView)itemView.findViewById(android.R.id.text1);
       }
   }
}

