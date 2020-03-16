package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.communitycleanup.HomeActivities.AboutActivity;
import com.example.communitycleanup.HomeActivities.CheckInActivity;
import com.example.communitycleanup.HomeActivities.CheckOutActivity;
import com.example.communitycleanup.HomeActivities.DrugEvidenceActivity;
import com.example.communitycleanup.HomeActivities.EventsActivity;
import com.example.communitycleanup.HomeActivities.FlyTippingActivity;
import com.google.firebase.auth.FirebaseUser;
import android.content.Intent;
import android.view.View;

public class HomeScreen extends AppCompatActivity {
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void events(View view)
    {
        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
        startActivity(intent);
    }

    public void ReportDrug(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DrugEvidenceActivity.class);
        startActivity(intent);
    }

    public void ReportFlyTipping(View view)
    {
        Intent intent = new Intent(getApplicationContext(), FlyTippingActivity.class);
      startActivity(intent);
    }

    public void checkIn(View view) {
        Intent intent = new Intent(getApplicationContext(), CheckInActivity.class);
        startActivity(intent);
    }

    public void checkOut(View view) {
        Intent intent = new Intent(getApplicationContext(), CheckOutActivity.class);
        startActivity(intent);
    }

    public void about(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
