package com.example.communitycleanup.HomeActivities.CheckIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.communitycleanup.Data.CheckInDatabase;
import com.example.communitycleanup.Data.EventDatabase;
import com.example.communitycleanup.DataTransfer.Event;
import com.example.communitycleanup.R;
//Test
/**A class representing the Check In page
 *
 */
public class CheckInActivity extends AppCompatActivity {
    EventDatabase eDB;
    CheckInDatabase cDB;
    TextView t1,t2,t3,t4;
    CheckBox c1;
    Event thisEvent;

    /**Set the layout to the layout stored in the Check In activity
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        setTitle("Check In");
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e){
            System.out.println("null pointer exception");
        }

        eDB = new EventDatabase(this);
        eDB.populate();
        cDB = new CheckInDatabase(this);

        thisEvent = eDB.isEventRunning();

        t1 = findViewById(R.id.textView21);
        t2 = findViewById(R.id.textView22);
        t3 = findViewById(R.id.textView23);
        t4 = findViewById(R.id.textView24);
        c1 = findViewById(R.id.checkBox);

        t1.setText(thisEvent.getDescription());
        t2.setText(thisEvent.getLocation());
        t3.setText(thisEvent.getStart());
        t4.setText(thisEvent.getFinish());
    }

    public void logCheckIn(View view){
        if (c1.isChecked())
        {
            cDB.checkIn(thisEvent);
            Intent intent = new Intent(getApplicationContext(), CheckInSuccess.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Tick to Accept Terms and Conditions!",Toast.LENGTH_LONG).show();
        }
    }
}
