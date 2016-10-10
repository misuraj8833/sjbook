package com.mishrafamily.sjbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    EditText editTextEventDescription;
    String dept;
    Button buttonSubmit;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        Spinner spinner_dept = (Spinner) findViewById(R.id.spinnerTeacherDept);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Semester,android.R.layout.simple_list_item_1);
        spinner_dept.setAdapter(adapter);

        spinner_dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long
                    id) {
                Object department = parent.getItemAtPosition(position);
                dept=department.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Firebase Reference
        Firebase.setAndroidContext(this);

        editTextEventDescription=(EditText)findViewById(R.id.editTextEventDescription);
        buttonSubmit=(Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventdes1 = editTextEventDescription.getText().toString();
                String dept1= dept;
                //mref = new Firebase(url);
                mref = new Firebase("https://sjbook-b02b6.firebaseio.com");
                // String key = mref.child(dept).push().getKey();
                mref.child(dept1).push().setValue(eventdes1);
                Toast.makeText(getBaseContext(), "Values Persisted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonReset=(Button)findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code about the reset button;
                //editTextName.setText("");
                //editTextPid.setText("");
                editTextEventDescription.setText("");
                Toast.makeText(getBaseContext(),"Please again enter the crendentials",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    private void createMenu(Menu menu) {
        MenuItem mnu=menu.add(0,1,1,R.string.signOut);
        {
            mnu.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        selectItem(item);
        return true;
    }

    private void selectItem(MenuItem item) {
        int itemId=item.getItemId();
        switch (itemId){
            case 1:Toast.makeText(getBaseContext(),"To be Implemented",Toast.LENGTH_SHORT).show();
        }
    }
}

