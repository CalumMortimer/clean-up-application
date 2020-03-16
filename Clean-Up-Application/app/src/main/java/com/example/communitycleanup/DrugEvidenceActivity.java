package com.example.communitycleanup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DrugEvidenceActivity extends AppCompatActivity {

    private LogAnIssue issue;
    private EditText inputPostCode;
    private EditText inputDescription;
    private Button btnChoose;
    private Button btnUpload;
    private Button btnSubmit;
    private ImageView pic;

    //LogAnIssue userlog;
    MainActivity main1;
    LogIssueDatabase dbase;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_evidence);

        inputPostCode = findViewById(R.id.editText5);
        inputDescription = findViewById(R.id.editText7);
        btnChoose = findViewById(R.id.button12);
        btnSubmit = findViewById(R.id.button11);
        btnUpload = findViewById(R.id.button13);
        //pic = findViewById(R.id.imageView);


    }

    public void logButton(View v) {
        //String s = main1.email.getText().toString();
        String postcode = inputPostCode.getText().toString();
        String description = inputDescription.getText().toString();


     if(TextUtils.isEmpty(postcode) || TextUtils.isEmpty(description)){
         Toast.makeText(getApplicationContext(),"Please provide a Postcode and a Description of what you found",Toast.LENGTH_SHORT).show();
     }
     else{
         Toast.makeText(getApplicationContext(),"Issue Reported",Toast.LENGTH_SHORT).show();
         inputPostCode.getText().clear();
         inputDescription.getText().clear();
         //LogAnIssue log = new LogAnIssue(postcode, description);
         //dbase.addIssue(log);


     }

    }






}
