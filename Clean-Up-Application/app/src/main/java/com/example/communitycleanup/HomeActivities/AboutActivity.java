package com.example.communitycleanup.HomeActivities;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.communitycleanup.R;


public class AboutActivity extends Activity {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //get data passed in, using getStringExtra()

        Bundle bundle = getIntent().getExtras();
    }
    public void onClick (View view) {
        // use an intent object to return data
        Intent i = new Intent();

        //use the setData() method to return a value
        i.setData(Uri.parse("You are back on the home screen"));
        setResult(RESULT_OK, i);
        //destroy activity
        finish();
    }
}