package com.example.communitycleanup.HomeActivities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.communitycleanup.R;

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

        TableLayout tb = findViewById(R.id.tableLayout);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT,1f));

        TextView[] textViewArray = {null,null,null,null,null};
        float[] weights = {1.0f,1.0f,1.0f,0.5f,0.7f};


        tb.setStretchAllColumns(true);
        ;
        for (int i=0;i<5;i++)
        {
            textViewArray[i] = new TextView(this);
            textViewArray[i].setLayoutParams(new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT,weights[i]));
            tr.addView(textViewArray[i]);
        }

        CheckBox myCheckBox = new CheckBox(this);
        myCheckBox.setLayoutParams(new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT,0.5f));
        tr.addView(myCheckBox);

        textViewArray[0].setText("April Cleanup");
        textViewArray[1].setText("Beach House");
        textViewArray[2].setText("04/04/20");
        textViewArray[3].setText("10:00");
        textViewArray[4].setText("12:00");


        tb.addView(tr);




        /*insert("April Cleanup","Beach House","04/04/2020","10:00","12:00","No");
        insert("May Cleanup","North Hut","03/05/2020","10:00","12:00","No");
        insert("June Cleanup","South Hut","06/06/2020","10:00","12:00","No");*/
    }
}
