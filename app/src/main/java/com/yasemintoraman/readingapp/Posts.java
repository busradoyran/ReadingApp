package com.yasemintoraman.readingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Posts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
    }
    public void notificationScreen(View view){
        Intent intent = new Intent(Posts.this, Notifications.class);
        startActivity(intent);

    }
}