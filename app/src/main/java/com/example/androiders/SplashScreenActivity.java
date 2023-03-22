package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreenActivity extends AppCompatActivity {
    LottieAnimationView android;
    TextView textView;
    ConstraintLayout constraintLayout;
    Animation txtAn, layoutAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        txtAn= AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.end);
        layoutAn= AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.start);

        textView= findViewById(R.id.sptxt);
        constraintLayout= findViewById(R.id.conMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                constraintLayout.setVisibility(View.VISIBLE);
                constraintLayout.setAnimation(layoutAn);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setVisibility(View.VISIBLE);
                        textView.setAnimation(txtAn);
                    }
                },500);

            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        },4000);
    }
}