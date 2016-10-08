package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;


public class ShowEvent extends AppCompatActivity {
    Firebase mref;
    ListView listView;
    String url = "https://sjbook-b02b6.firebaseio.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);
        Firebase.setAndroidContext(this);
        mref = new Firebase(url);
        listView=(ListView)findViewById(R.id.listViewEvents);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase ref = mref.child("Events");
        final FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this,String.class,R.layout.support_simple_spinner_dropdown_item,ref) {
            @Override
            protected void populateView(View view, String s, int i) {



            }
        };
        listView.setAdapter(adapter);
    }
}

