package com.eshwarne.docblock;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.imageViewHomeLogo);
        Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_slide_up);
        logo.startAnimation(aniSlide);
    new Handler().postDelayed(new Runnable() {
            public void run() {

                    Intent intent = new Intent(MainActivity.this,HomeScreen.class);
                    startActivity(intent);
                finish();
            }
        }, 3 * 1000);
    }
}
