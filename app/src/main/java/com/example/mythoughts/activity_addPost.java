package com.example.mythoughts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class activity_addPost extends AppCompatActivity {

    EditText title_blog,description_blog;
    Button upload;
    ImageView blog_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        title_blog=findViewById(R.id.title);
        description_blog=findViewById(R.id.description_blog);
        upload=findViewById(R.id.upload);
        blog_image=findViewById(R.id.post_image_blog);
        

    }
}