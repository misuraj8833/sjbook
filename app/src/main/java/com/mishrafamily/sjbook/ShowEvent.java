package com.mishrafamily.sjbook;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;



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
        //return super.onCreateOptionsMenu(menu);
       createMenu(menu);
        return true;

    }

    public void createMenu(Menu menu) {
        MenuItem mnu1=menu.add(0,0,0,R.string.Item1);
        {
            mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        MenuItem mnu2=menu.add(0,1,1,R.string.Item2);
        {
            mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        MenuItem mnu3 = menu.add(0,2,2,R.string.Item3);
        {
            mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        MenuItem mnu4 = menu.add(0,3,3,R.string.Item4);
        {
            mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        MenuItem mnu5 = menu.add(0,4,4,R.string.Item5);
        {
            mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        MenuItem mnu6=menu.add(0,5,5,R.string.signOut);
        {
            mnu6.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // return super.onOptionsItemSelected(item);
        selectItem(item);
        return true;
    }

    private void selectItem(MenuItem item) {
        int itemId=item.getItemId();

        switch (itemId){
            case 0:mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Civil");
                FirebaseListAdapter<String> firebaseListAdapter0 = new FirebaseListAdapter<String>(
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
                listViewShowEvent.setAdapter(firebaseListAdapter0);
                break;
//---------------------------------------------------------------------------------------------------------------
            case 1:mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Computer Engineering");
                FirebaseListAdapter<String> firebaseListAdapter1 = new FirebaseListAdapter<String>(
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
                listViewShowEvent.setAdapter(firebaseListAdapter1);
                break;

//-----------------------------------------------------------------------------------------------------------------------
            case 2:mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Extc");
                FirebaseListAdapter<String> firebaseListAdapter2 = new FirebaseListAdapter<String>(
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
                listViewShowEvent.setAdapter(firebaseListAdapter2);
                break;
//---------------------------------------------------------------------------------------------------------------------
            case 3:mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Information Technology");
                FirebaseListAdapter<String> firebaseListAdapter3 = new FirebaseListAdapter<String>(
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
                listViewShowEvent.setAdapter(firebaseListAdapter3);
                break;
//--------------------------------------------------------------------------------------------------------------------
            case 4:mref = new Firebase("https://sjbook-b02b6.firebaseio.com/Mechanical");
                FirebaseListAdapter<String> firebaseListAdapter4 = new FirebaseListAdapter<String>(
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
                listViewShowEvent.setAdapter(firebaseListAdapter4);
                break;
//----------------------------------------------------------------------------------------------------------------
            case 5:Toast.makeText(getBaseContext(),"To Be Implemented",Toast.LENGTH_SHORT).show();
                break;
                //TODO:To implement signout method.

        }

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
    }
}




