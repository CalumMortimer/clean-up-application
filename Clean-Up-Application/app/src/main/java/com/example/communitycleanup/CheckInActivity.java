package com.example.communitycleanup;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckInActivity extends AppCompatActivity {
    EditText event;
    EditText name;
    EditText time;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        event = (EditText) findViewById(R.id.editTextEvent);
        name = (EditText) findViewById(R.id.editTextName);
        time = (EditText) findViewById(R.id.editTextTime);
        listView = (ListView) findViewById(R.id.listViewCheckin);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(arrayAdapter);
    }

    public void logCheckIn(View view){
        String checkInEvent = event.getText().toString();
        String checkInName = name.getText().toString();
        String checkInTime = time.getText().toString();
        myList.add(myList.size(),  "Event: " + checkInEvent + " Name: " + checkInName + " Time: " + checkInTime);
        arrayAdapter.notifyDataSetChanged();
    }
}
