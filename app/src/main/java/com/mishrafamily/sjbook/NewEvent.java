package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class NewEvent extends AppCompatActivity {
    Firebase mref;
    EditText editTextName;
    EditText editTextPid;
    EditText editTextEventDescription;
    String dept;
    Button buttonSubmit;
    Button buttonReset;
    String url ="https://sjbook-b02b6.firebaseio.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        Spinner spinner_dept = (Spinner) findViewById(R.id.spinnerTeacherDept);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Semester, R.layout.support_simple_spinner_dropdown_item);
        spinner_dept.setAdapter(adapter);

        spinner_dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long
                    id) {
                Object semester = parent.getItemAtPosition(position);
                dept=semester.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Firebase.setAndroidContext(this);

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextPid=(EditText)findViewById(R.id.editTextPid);
        editTextEventDescription=(EditText)findViewById(R.id.editTextEventDescription);


        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1= editTextName.getText().toString();
                String pid1=editTextPid.getText().toString();
                String eventdes1 = editTextEventDescription.getText().toString();
                String dept1=dept;
                User user = new User(name1,pid1,eventdes1,dept1);
                mref = new Firebase(url);
                String key = mref.child("Events").push().getKey();
                mref.child("Events").child(key).setValue(user);
                Toast.makeText(getBaseContext(),"Values Persisted",Toast.LENGTH_SHORT).show();

            }
        });

        buttonReset=(Button)findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code about the reset button;
                editTextName.setText("");
                editTextPid.setText("");
                editTextEventDescription.setText("");
                Toast.makeText(getBaseContext(),"Please again enter the crendentials",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class User {

        public String name;
        public String pid;
        public String eventdes;
        public String dept;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String name, String pid, String eventdes,String dept) {
            this.name = name;
            this.pid = pid;
            this.eventdes=eventdes;
            this.dept=dept;
        }

    }




}

