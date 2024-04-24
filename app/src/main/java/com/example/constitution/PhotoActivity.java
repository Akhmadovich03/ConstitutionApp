package com.example.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PhotoActivity extends AppCompatActivity {
    private static final long PHOTO_DISPLAY_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(PhotoActivity.this, MainActivity.class));
            finish();
        }, PHOTO_DISPLAY_DURATION);
    }
}