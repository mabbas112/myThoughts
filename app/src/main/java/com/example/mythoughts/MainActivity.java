package com.example.mythoughts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button register,login;
    private EditText edittext_email, edittext_password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        edittext_email= (EditText) findViewById(R.id.email);
        edittext_password= (EditText) findViewById(R.id.password);

        register.setOnClickListener(this);
        login.setOnClickListener(this);
        auth=FirebaseAuth.getInstance();
    }
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.register:
                 startActivity(new Intent(this, activity_register_user.class));
                 break;
             case R.id.login:
                  checkValidation();
                  loginUser();
                 break;
         }
    }



    private void checkValidation() {
        String Email= edittext_email.getText().toString().trim();
        String Password= edittext_password.getText().toString().trim();
        if(Email.isEmpty()){
            edittext_email.setError("Email is required!");
            edittext_email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            edittext_email.setError("Please provide valid email!");
            edittext_email.requestFocus();
            return;
        }
        if(Password.isEmpty()){
            edittext_password.setError("Password is required!");
            edittext_password.requestFocus();
            return;
        }
        if(Password.length()<6){
            
            edittext_password.setError("Password Should not less than 6!");
            edittext_password.requestFocus();
            return;
        }

    }
    private void loginUser() {
        String Email= edittext_email.getText().toString().trim();
        String Password= edittext_password.getText().toString().trim();
        auth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,activity_home.class));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
Toast.makeText(MainActivity.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
      }

    //we will check if the user is already login take to home screen
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=auth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(MainActivity.this, activity_home.class));
        }
    }
}
