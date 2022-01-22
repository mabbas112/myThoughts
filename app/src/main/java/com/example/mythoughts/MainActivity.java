package com.example.mythoughts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button register,login,forgetPassword;
    private EditText edittext_email, edittext_password;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        forgetPassword=(Button) findViewById(R.id.forgetPassword);
        edittext_email= (EditText) findViewById(R.id.email);
        edittext_password= (EditText) findViewById(R.id.password);

        register.setOnClickListener(this);
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);

        
    }
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.register:
                 startActivity(new Intent(this, activity_register_user.class));
                 break;
             case R.id.login:
                  checkValidation();
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
}
