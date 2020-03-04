package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        String username = userNameBox.getText().toString();
        String password = passWordBox.getText().toString();

        if ((username.equals("admin"))&&(password.equals("password")))
        {
            //user is authenticated
            User authenticatedUser = new User();
            authenticatedUser.setUsername(username);
            authenticatedUser.setPassword(password);

            Intent intent = new Intent(this,HomeScreen.class);
            String mySerial = authenticatedUser.getSerialData();
            intent.putExtra("authenticated_user",mySerial);



       //     startActivity(intent);
            startActivity(intent);
        }
        else
        {
            //user is not authenticated

        }
    }

}
