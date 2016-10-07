package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class Sign_up extends AppCompatActivity {
    Firebase mref;
    EditText editTextName;
    EditText editTextPid;
    String sem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Spinner spinner_semester = (Spinner) findViewById(R.id.spinner);
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

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextPid=(EditText)findViewById(R.id.editTextPid);
    }

        public void OnClickbuttonSubmit(View view){
           /* mref= new Firebase("https://sjbook-b02b6.firebaseio.com/username");
            mref.setValue(editTextName.getText().toString());
            mref= new Firebase("https://sjbook-b02b6.firebaseio.com/pid");
            mref.setValue(editTextPid.getText().toString());
            mref= new Firebase("https://sjbook-b02b6.firebaseio.com/sem");
            mref.setValue(sem);*/



        }
    public void OnClickbuttonReset(View view){
        // code about the reset button;
    }
}
