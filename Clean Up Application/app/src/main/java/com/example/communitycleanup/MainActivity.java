package com.example.communitycleanup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText3);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void registerAttempt(View view){
        String emailString = email.getText().toString();
        String passString = password.getText().toString();

        if(TextUtils.isEmpty(emailString)){
            Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passString)){
            Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length()<6){
            Toast.makeText(getApplicationContext(),"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
        }
        else {
            firebaseAuth.createUserWithEmailAndPassword(emailString, passString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error registering details. Already registered?", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void logInAttempt(View view){
        String emailString = email.getText().toString();
        String passString = password.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(emailString,passString).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
