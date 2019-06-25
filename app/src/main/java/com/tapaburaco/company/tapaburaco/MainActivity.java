package com.tapaburaco.company.tapaburaco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //Checks if user is signed in if true send to Home screen otherwise send it to login screen
        Intent i;
        if(currentUser != null){
            i = new Intent(getApplicationContext(),HomeActivity.class);
        } else {
            i = new Intent(getApplicationContext(),LoginActivity.class);
        }

        if(i != null){
            startActivity(i);
        }
    }


}
