package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class prac extends AppCompatActivity {

    Firebase mref;
    TextView textView;
    Button buttonS;
    Button buttonf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac);
        Firebase.setAndroidContext(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        textView=(TextView)findViewById(R.id.textViewCondition);
        buttonS =(Button)findViewById(R.id.buttonSunny);
        buttonf =(Button)findViewById(R.id.buttonfoggy);

        mref= new Firebase("https://sjbook-b02b6.firebaseio.com/string");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textView.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.setValue("sunny");
            }
        });
        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.setValue("foggy");
            }
        });
    }
}
