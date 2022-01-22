package com.example.mythoughts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button register,login;
    private EditText edittext_email, edittext_password;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        edittext_email= (EditText) findViewById(R.id.email);
        edittext_password= (EditText) findViewById(R.id.password);
        
    }
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.register:
                 startActivity(new Intent(this, register_user.class));
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
