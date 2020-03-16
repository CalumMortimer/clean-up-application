package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        Intent intent = new Intent(getApplicationContext(),EventsActivity.class);
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
}
