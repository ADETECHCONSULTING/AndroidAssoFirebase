package com.example.adama.androidassofirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText edt_email;
    private EditText edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edt_email = findViewById(R.id.input_email);
        edt_password = findViewById(R.id.input_password);

        auth = FirebaseAuth.getInstance();
    }


    public void btn_createClicked(View view){
        String email = edt_email.getText().toString();
        String password = edt_password.getText().toString();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        else
                            Toast.makeText(SignupActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void txv_alreadyCreated(View view){
        startActivity(new Intent(SignupActivity.this, LoginActivity.class));
    }
}
