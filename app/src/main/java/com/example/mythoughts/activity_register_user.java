package com.example.mythoughts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_register_user extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText edittext_name,edittext_email, edittext_password;
    private TextView banner;
    private Button register_user;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        //mAuth = FirebaseAuth.getInstance();
        
        //logo image
        banner =(TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);
        //Register button
        register_user = (Button) findViewById(R.id.login);
        register_user.setOnClickListener(this);
        //Input fields
        edittext_name = (EditText) findViewById(R.id.fullname);
        edittext_email= (EditText) findViewById(R.id.email);
        edittext_password= (EditText) findViewById(R.id.password);
        //Progress bar
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
   
    }
     public void onClick(View view) {
        switch (view.getId()){
            case R.id.banner:
               startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.login:
                registeruser();
                break;
        }
    }

    private void registeruser() {
        String FullName= edittext_name.getText().toString().trim();
        String Email= edittext_email.getText().toString().trim();
        String Password= edittext_password.getText().toString().trim();
        if(FullName.isEmpty()){
            edittext_name.setError("Full name is required!");
            edittext_name.requestFocus();
            return;
        }
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
       /* progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            user userObj=new user(FullName,Email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userObj).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                     if(task.isSuccessful()){
                                         Toast.makeText(com.example.mythoughts.register_user.this, "User has been registered Successfully!",Toast.LENGTH_LONG).show();
                                         progressBar.setVisibility(View.VISIBLE);
                                     }else{
                                         Toast.makeText(com.example.mythoughts.register_user.this, "Failed to registered!",Toast.LENGTH_LONG).show();
                                     progressBar.setVisibility(View.GONE);
                                     }
                                }
                            });
                        }
                    }
                });*/
    }
}
