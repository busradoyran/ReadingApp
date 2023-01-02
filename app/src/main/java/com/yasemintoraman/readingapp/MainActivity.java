package com.yasemintoraman.readingapp;

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

    private EditText editEmail, editPassword;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText)findViewById(R.id.sign_up_email);
        editPassword = (EditText)findViewById(R.id.sign_up_password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void signUp(View view){
        txtEmail = editEmail.getText().toString();
        txtSifre = editPassword.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)){
            mAuth.createUserWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Registration Successful",Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(MainActivity.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
        }else
            Toast.makeText(this,"Email and Password Cannot Be Empty", Toast.LENGTH_SHORT).show();

        Thread loginScreen = new Thread() {
            public void run() {
                try {
                    sleep(6000);
                    //6 saniye sonunda class davet et.
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
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
        loginScreen.start();
    }
}