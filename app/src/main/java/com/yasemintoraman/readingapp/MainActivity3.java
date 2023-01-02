package com.yasemintoraman.readingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private  int selectedTab = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final LinearLayout homeLayout = findViewById(R.id.home_layout);
        final LinearLayout messageLayout = findViewById(R.id.message_layout);
        final LinearLayout notificationLayout = findViewById(R.id.notification_layout);
        final LinearLayout profileLayout = findViewById(R.id.profile_layout);

        final ImageView homeImage = findViewById(R.id.home_image);
        final ImageView messageImage = findViewById(R.id.message_image);
        final ImageView notificationImage = findViewById(R.id.notification_image);
        final ImageView profileImage = findViewById(R.id.profile_image);

        final TextView homeText = findViewById(R.id.home_text);
        final TextView messageText = findViewById(R.id.message_text);
        final TextView notificationText = findViewById(R.id.notification_text);
        final TextView profileText = findViewById(R.id.profile_text);

        // set home fragment by default
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, HomeFragment.class,null).commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if home is already selected or not.
                if (selectedTab != 1){
                    // set home fragment
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, HomeFragment.class,null).commit();

                    // select other tabs expect home tab
                    messageText.setVisibility(View.GONE);
                    notificationText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    messageImage.setImageResource(R.drawable.messages_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home tab
                    homeText.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.home_selected_icon);
                    homeLayout.setBackgroundColor(R.drawable.round_back_home_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f, Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    // select 1st tab as selected tab
                    selectedTab = 1;
                }
            }
        });

        messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if message is already selected or not.
                if (selectedTab != 2){
                    // set message fragment
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, MessageFragment.class,null).commit();

                    // select other tabs expect message tab
                    homeText.setVisibility(View.GONE);
                    notificationText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select message tab
                    messageText.setVisibility(View.VISIBLE);
                    messageImage.setImageResource(R.drawable.messages_selected_icon);
                    messageLayout.setBackgroundColor(R.drawable.round_back_message_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f, Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    messageLayout.startAnimation(scaleAnimation);

                    // select 2nd tab as selected tab
                    selectedTab = 2;
                }
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if notification is already selected or not.
                if (selectedTab != 3){
                    // set notification fragment
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, NotificationFragment.class,null).commit();

                    // select other tabs expect notification tab
                    messageText.setVisibility(View.GONE);
                    homeText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    messageImage.setImageResource(R.drawable.messages_icon);
                    homeImage.setImageResource(R.drawable.home_icon);
                    profileImage.setImageResource(R.drawable.profile_icon);

                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select notification tab
                    notificationText.setVisibility(View.VISIBLE);
                    notificationImage.setImageResource(R.drawable.notification_selected_icon);
                    notificationLayout.setBackgroundColor(R.drawable.round_back_notification_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f, Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    notificationLayout.startAnimation(scaleAnimation);

                    // select 3rd tab as selected tab
                    selectedTab = 3;
                }
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if profile is already selected or not.
                if (selectedTab != 4){
                    // set profile fragment
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, ProfileFragment.class,null).commit();

                    // select other tabs expect profile tab
                    messageText.setVisibility(View.GONE);
                    notificationText.setVisibility(View.GONE);
                    homeText.setVisibility(View.GONE);

                    messageImage.setImageResource(R.drawable.messages_icon);
                    notificationImage.setImageResource(R.drawable.notification_icon);
                    homeImage.setImageResource(R.drawable.home_icon);

                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select profile tab
                    profileText.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.profile_selected_icon);
                    profileLayout.setBackgroundColor(R.drawable.round_back_profile_100);

                    // create animation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f, Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);

                    // select 4th tab as selected tab
                    selectedTab = 4;
                }
            }
        });
    }
}
