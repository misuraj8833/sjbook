package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Sign_up extends AppCompatActivity {
    Firebase mref;
    EditText editTextName;
    EditText editTextPid;
    EditText editTextBranch;
    String sem;
    String url ="https://sjbook-b02b6.firebaseio.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        /*Spinner spinner_semester = (Spinner) findViewById(R.id.spinner);
        //String semarray[] = getResources().getStringArray(R.array.Semester);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Semester, R.layout.support_simple_spinner_dropdown_item);
       // spinner_semester.setAdapter(adapter);

        spinner_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object semester = parent.getItemAtPosition(position);
                sem=semester.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        Firebase.setAndroidContext(this);

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextPid=(EditText)findViewById(R.id.editTextPid);
        editTextBranch=(EditText)findViewById(R.id.editTextBranch);

    }
    public class User {

        public String name;
        public String pid;
        public String branch;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String pid, String branch) {
            this.name = name;
            this.pid = pid;
            this.branch=branch;
        }

    }




        public void OnClickbuttonSubmit(View view){
            String name1= editTextName.getText().toString();
            String pid1=editTextPid.getText().toString();
            String branch1 =editTextBranch.getText().toString();
            User user = new User(name1,pid1,branch1);
            mref = new Firebase(url);
            mref.child("teachers").child(pid1).setValue(user);
            Toast.makeText(getBaseContext(),"Values Persisted",Toast.LENGTH_SHORT).show();



        }
    public void OnClickbuttonReset(View view){
        // code about the reset button;
        editTextName.setText("");
        editTextPid.setText("");
        editTextBranch.setText("");
    }
}
