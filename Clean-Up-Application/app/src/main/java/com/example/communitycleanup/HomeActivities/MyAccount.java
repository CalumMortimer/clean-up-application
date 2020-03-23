package com.example.communitycleanup.HomeActivities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.communitycleanup.R;


public class MyAccount extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setTitle("My Account");
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e){
            System.out.println("null pointer exception");
        }
    }
}
