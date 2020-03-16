package com.example.communitycleanup.HomeActivities;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.communitycleanup.Data.LogIssueDatabase;
import com.example.communitycleanup.MainActivity;
import com.example.communitycleanup.R;

public class FlyTippingActivity extends AppCompatActivity {

    private LogAnIssue issue;
    private EditText inputPostCode1;
    private EditText inputDescription1;
    private Button btnChoose1;
    private Button btnUpload1;
    private Button btnSubmit1;
    private ImageView pic;

    //LogAnIssue userlog;
    MainActivity main1;
    LogIssueDatabase dbase;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fly_tipping);
        setTitle("Report Fly Tipping");

        inputPostCode1 = findViewById(R.id.editText5i);
        inputDescription1 = findViewById(R.id.editText7i);
        btnChoose1 = findViewById(R.id.button12i);
        btnSubmit1 = findViewById(R.id.button11i);
        btnUpload1 = findViewById(R.id.button13i);
        //pic = findViewById(R.id.imageView);
    }

    public void logButton1(View v) {
        //String s = main1.email.getText().toString();
        String postcode = inputPostCode1.getText().toString();
        String description = inputDescription1.getText().toString();


        if(TextUtils.isEmpty(postcode) || TextUtils.isEmpty(description)){
            Toast.makeText(getApplicationContext(),"Please provide a Postcode and a Description of what you found",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Issue Reported",Toast.LENGTH_SHORT).show();
            inputPostCode1.getText().clear();
            inputDescription1.getText().clear();
            //LogAnIssue log = new LogAnIssue(postcode, description);
            //dbase.addIssue(log);

        }
    }
}






