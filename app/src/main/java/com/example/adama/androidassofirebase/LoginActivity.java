package com.example.adama.androidassofirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.oob.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText edt_email;
    private EditText edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.input_email);
        edt_password = findViewById(R.id.input_password);

        auth = FirebaseAuth.getInstance();

    }


    public void btn_loginClicked(View view){
        String email = edt_email.getText().toString();
        String password = edt_password.getText().toString();


        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        else
                            Toast.makeText(LoginActivity.this, "NOT OK"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void txv_inscriptionClicked(View view){
        startActivity(new Intent(LoginActivity.this, SignupActivity.class));
    }
}
