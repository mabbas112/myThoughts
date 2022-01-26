package com.example.mythoughts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class passwordResetActivity extends AppCompatActivity {

    EditText email;
    Button recoverPassword;
    FirebaseAuth auth;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        email=findViewById(R.id.forgetEmail);
        recoverPassword=findViewById(R.id.forgetBtn);
  //AUth
  auth=FirebaseAuth.getInstance();
  pd=new ProgressDialog(this);
//Action bar and back error
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Forget Password");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reEmail=email.getText().toString();
                if(TextUtils.isEmpty(reEmail)){
                    email.setError("Email is required!");

                }else {
                    recoverPassword(reEmail);
                    }
                }
            });
    }

    private void recoverPassword(String email) {
                pd.setMessage("Please wait!");
                pd.show();
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            pd.dismiss();
                            Toast.makeText(passwordResetActivity.this,"Please check email is sent!",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(passwordResetActivity.this, MainActivity.class));

                        }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(passwordResetActivity.this,""+e,Toast.LENGTH_LONG).show();
            }
        });
    }
}