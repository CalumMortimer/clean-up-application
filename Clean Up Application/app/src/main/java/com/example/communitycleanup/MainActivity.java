package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logInAttempt(View view)
    {
        EditText userNameBox = (EditText)findViewById(R.id.editText);
        EditText passWordBox = (EditText)findViewById(R.id.editText3);

        if ((userNameBox.getText().toString()=="admin")&&(passWordBox.getText().toString()=="password"))
        {
            //user is authenticated
        }
        else
        {
            //user is not authenticated

        }
    }

}
