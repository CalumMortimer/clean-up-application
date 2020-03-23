package com.example.communitycleanup.HomeActivities.CheckOut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.communitycleanup.Data.CheckInDatabase;
import com.example.communitycleanup.DataTransfer.Event;
import com.example.communitycleanup.R;

public class CheckOutActivity extends AppCompatActivity {
    CheckInDatabase cDB;
    TextView t1,t2,t3,t4;
    EditText e1;

    /**Set the layout to the layout stored in the Check In activity
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTitle("Check Out");
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e){
            System.out.println("null pointer exception");
        }

        cDB = new CheckInDatabase(this);
        Event thisEvent = cDB.getCheckedInEvent();

        t1 = findViewById(R.id.textView21);
        t2 = findViewById(R.id.textView22);
        t3 = findViewById(R.id.textView23);
        t4 = findViewById(R.id.textView24);
        e1 = findViewById(R.id.editText2);

        t1.setText(thisEvent.getDescription());
        t2.setText(thisEvent.getLocation());
        t3.setText(thisEvent.getStart());
        t4.setText(thisEvent.getFinish());
    }

    public void logCheckOut(View view){
        int noBags = 0;
        try{
            noBags = Integer.parseInt(e1.getText().toString());
        } catch(Exception E){}

        if (noBags>=1)
        {
            cDB.checkOut();
            Intent intent = new Intent(getApplicationContext(), CheckOutSuccess.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter a Number of Bags!",Toast.LENGTH_LONG).show();
        }
    }
}
