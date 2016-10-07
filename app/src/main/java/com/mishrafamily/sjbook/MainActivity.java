package com.mishrafamily.sjbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick1(View view){
        Intent intent = new Intent("com.mishrafamily.sjbook01");
        startActivity(intent);
    }
    public void OnClick2(View view){
        Intent intent1 = new Intent("com.mishrafamily.sjbook02");
        startActivity(intent1);
    }
    public void OnClick3(View view){
        Intent intent1 = new Intent("com.mishrafamily.sjbook03");
        startActivity(intent1);
    }

}
