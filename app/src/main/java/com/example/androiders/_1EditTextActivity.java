package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class _1EditTextActivity extends AppCompatActivity {

    Button next, back;
    Button i1, i2;
    Button button;
    Animation up, down;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        next=(Button) findViewById(R.id.BTNnext);
        back= (Button) findViewById(R.id.BTNback);
        i1= findViewById(R.id.xmlbtn);
        i2= findViewById(R.id.javabtn);
        button= findViewById(R.id.circularbtn);
        vibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);

        up= AnimationUtils.loadAnimation(this, R.anim.scale_up);
        down= AnimationUtils.loadAnimation(this, R.anim.scale_down);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(_1EditTextActivity.this, _2ButtonsActivity.class));
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/res/layout/activity_edit_text.xml");
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/java/com/example/androiders/_1EditTextActivity.java");
            }
        });

        ImageView homebtn= (ImageView) findViewById(R.id.homeBtn);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), _0MainActivity.class));
                finishAffinity();
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}