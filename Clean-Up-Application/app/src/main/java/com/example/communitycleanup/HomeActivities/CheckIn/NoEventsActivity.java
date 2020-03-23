package com.example.communitycleanup.HomeActivities.CheckIn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.communitycleanup.R;

public class NoEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_events);
        setTitle("Check In");
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e){
            System.out.println("null pointer exception");
        }
    }
}
