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
}
