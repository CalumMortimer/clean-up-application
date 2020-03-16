package com.example.communitycleanup.HomeActivities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.communitycleanup.Data.EventDatabase;
import com.example.communitycleanup.DataTransfer.Event;
import com.example.communitycleanup.R;

import java.util.ArrayList;

/**The View Upcoming Events activity class
 */
public class EventsActivity extends AppCompatActivity {

    /**On creation, populate the upcoming events table from the data stored in the events
     * database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        EventDatabase eDB = new EventDatabase(this);
        eDB.populate();
        ArrayList<Event> myEventList = new ArrayList<Event>();
        myEventList = eDB.getEventsList();

        TableLayout tb = findViewById(R.id.tableLayout);
        tb.setStretchAllColumns(true);

        for(int i=0;(i<10);i++)
        {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT,1f));

            TextView[] textViewArray = {null,null,null,null,null};
            float[] weights = {1.0f,1.0f,1.0f,0.5f,0.7f};

            for (int j=0;j<5;j++)
            {
                textViewArray[j] = new TextView(this);
                textViewArray[j].setLayoutParams(new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT,weights[j]));
                tr.addView(textViewArray[j]);
            }

            if (i<myEventList.size()) {
                CheckBox myCheckBox = new CheckBox(this);
                myCheckBox.setLayoutParams(new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT,0.5f));
                tr.addView(myCheckBox);

                textViewArray[0].setText(myEventList.get(i).getDescription());
                textViewArray[1].setText(myEventList.get(i).getLocation());
                textViewArray[2].setText(myEventList.get(i).getDate());
                textViewArray[3].setText(myEventList.get(i).getStart());
                textViewArray[4].setText(myEventList.get(i).getFinish());
            }
            tb.addView(tr);
        }
    }
}
