package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.communitycleanup.Data.EventDatabase;
import com.example.communitycleanup.HomeActivities.AboutActivity;
import com.example.communitycleanup.HomeActivities.CheckInActivity;
import com.example.communitycleanup.HomeActivities.CheckOutActivity;
import com.example.communitycleanup.HomeActivities.DrugEvidenceActivity;
import com.example.communitycleanup.HomeActivities.EventsActivity;
import com.example.communitycleanup.HomeActivities.FlyTippingActivity;
import com.example.communitycleanup.HomeActivities.MyAccount;
import com.google.firebase.auth.FirebaseUser;
import android.content.Intent;
import android.view.View;

/**The HomeScreen class - contains tiles which re-direct to the various
 * sub-menus of the application
 */
public class HomeScreen extends AppCompatActivity {
    EventDatabase eDB;
    /**Set the layout to the home screen activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setTitle("Home");

        eDB = new EventDatabase(this);
        eDB.populate();
    }

    /**Open the EventsActivity
     *
     * @param view the "show upcoming events" button
     */
    public void events(View view)
    {
        Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
        startActivity(intent);
    }

    /**Open the DrugEvidenceActivity
     *
     * @param view the "report drug evidence" button
     */
    public void ReportDrug(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DrugEvidenceActivity.class);
        startActivity(intent);
    }

    /**Open the FlyTippingActivity
     *
     * @param view the "report fly tipping" button
     */
    public void ReportFlyTipping(View view)
    {
        Intent intent = new Intent(getApplicationContext(), FlyTippingActivity.class);
      startActivity(intent);
    }

    /**Open the CheckInActivity
     *
     * @param view the "check in" button
     */
    public void checkIn(View view) {
        if (eDB.isEventRunning()==null){
            Intent intent = new Intent(getApplicationContext(), NoEventsActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), CheckInActivity.class);
            startActivity(intent);
        }
    }

    /**Open the CheckOut activity
     *
     * @param view the "check out" button
     */
    public void checkOut(View view) {
        Intent intent = new Intent(getApplicationContext(), CheckOutActivity.class);
        startActivity(intent);
    }

    /**Open the About activity
     *
     * @param view the "about us" button
     */
    public void about(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void account(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MyAccount.class);
        startActivity(intent);
    }
}
