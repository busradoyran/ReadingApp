package com.yasemintoraman.readingapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    private EditText editEmail, editPassword;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = (EditText)findViewById(R.id.login_email);
        editPassword = (EditText)findViewById(R.id.login_password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View view){
        txtEmail = editEmail.getText().toString();
        txtSifre = editPassword.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)){
            mAuth.signInWithEmailAndPassword(txtEmail, txtSifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }else
            Toast.makeText(this,"Email and Password Cannot Be Empty", Toast.LENGTH_SHORT).show();

        Thread homeScreen = new Thread() {
            public void run() {
                try {
                    sleep(6000);
                    //6 saniye sonunda class davet et.
                    startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        homeScreen.start();
    }



    public void signUpScreen(View view){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}