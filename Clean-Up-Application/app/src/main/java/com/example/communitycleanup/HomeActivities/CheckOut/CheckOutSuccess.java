package com.example.communitycleanup.HomeActivities.CheckOut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.communitycleanup.R;

public class CheckOutSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_success);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e){
            System.out.println("null pointer exception");
        }
    }
}
