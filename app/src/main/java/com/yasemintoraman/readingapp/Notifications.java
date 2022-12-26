package com.yasemintoraman.readingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }

    public void backProfileScreen(View view){
        Intent intent = new Intent(Notifications.this, Posts.class);
        startActivity(intent);

    }
}