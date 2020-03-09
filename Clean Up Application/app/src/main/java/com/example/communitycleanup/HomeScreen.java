package com.example.communitycleanup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {
    User authenticatedUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        /*Intent intent = getIntent();
        String myUserData = intent.getStringExtra("authenticated_user");
        User myUser = new User(myUserData);
        authenticatedUser = myUser;*/

       /* System.out.println(authenticatedUser.getUsername());
        System.out.println(authenticatedUser.getPassword());
        System.out.println(authenticatedUser.getEmail());
        System.out.println(authenticatedUser.getFirstName());
        System.out.println(authenticatedUser.getLastName());
        System.out.println(authenticatedUser.getCommunityGroup());*/
    }

    public void myMethod(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);


        User myUser = new User();

        String myString = myUser.getSerialData();

       // System.out.println(myString);

        intent.putExtra("my data",myString);

        startActivity(intent);
    }
}
