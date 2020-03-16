package com.example.communitycleanup;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {
    EditText name;
    EditText event;
    EditText time;
    EditText noBags;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        name = (EditText) findViewById(R.id.editTextName2);
        event = (EditText) findViewById(R.id.editTextEvent2);
        time = (EditText) findViewById(R.id.editTextTime2);
        noBags = (EditText) findViewById(R.id.editTextBags);
        listView = (ListView) findViewById(R.id.listViewCheckOut);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(arrayAdapter);

    }

    public void logCheckOut(View view){
        String checkOutEvent = event.getText().toString();
        String checkOutName = name.getText().toString();
        String checkOutTime = time.getText().toString();
        String checkOutNoBags = noBags.getText().toString();
        myList.add(myList.size(),  "Event: " + checkOutEvent + " Name: " + checkOutName + " Time: " + checkOutTime + "No. Bags: " + checkOutNoBags);
        arrayAdapter.notifyDataSetChanged();
    }
}
