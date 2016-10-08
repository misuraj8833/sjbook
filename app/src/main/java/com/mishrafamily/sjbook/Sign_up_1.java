package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Sign_up_1 extends AppCompatActivity {
    Firebase mref;
    EditText editTextStudentName;
    EditText editTextStudentPid;
    String sem;
    String url ="https://sjbook-b02b6.firebaseio.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_1);
         Spinner spinner_semester = (Spinner) findViewById(R.id.spinnerStudentDepartment);
        //String semarray[] = getResources().getStringArray(R.array.Semester);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Semester, R.layout.support_simple_spinner_dropdown_item);
       spinner_semester.setAdapter(adapter);

        spinner_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object semester = parent.getItemAtPosition(position);
                sem=semester.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Firebase.setAndroidContext(this);
        editTextStudentName=(EditText)findViewById(R.id.editTextStudentName);
        editTextStudentPid=(EditText)findViewById(R.id.editTextStudentPid);

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

    public void OnClickbuttonStudentSubmit(View view) {
        String name1 = editTextStudentName.getText().toString();
        String pid1 = editTextStudentPid.getText().toString();
        String branch1 = sem;
        User user = new User(name1, pid1, branch1);
        mref = new Firebase(url);
        mref.child("Students").child(pid1).setValue(user);
        Toast.makeText(getBaseContext(), "Values Persisted", Toast.LENGTH_SHORT).show();
    }

        public void OnClickbuttonStudentReset(View view){
            // code about the reset button;
            editTextStudentName.setText("");
            editTextStudentPid.setText("");

        }



    }


