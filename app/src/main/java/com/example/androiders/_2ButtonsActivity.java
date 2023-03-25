package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import android.widget.ProgressBar;
import android.widget.TextView;

public class _2ButtonsActivity extends AppCompatActivity {
    Button next, back;

    ProgressBar p1,p2,p3,p4,p5;
    Button i1, i2;
    Button button;
    Vibrator vibrator;
    Animation up, down;

    ImageView imageView;
    CardView cardView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        next= findViewById(R.id.BTNnext);
        back= findViewById(R.id.BTNback);
        button= findViewById(R.id.circularbtn);

        i1= findViewById(R.id.xmlbtn);
        i2= findViewById(R.id.javabtn);

        vibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);

        up= AnimationUtils.loadAnimation(this, R.anim.scale_up);
        down= AnimationUtils.loadAnimation(this, R.anim.scale_down);



        imageView= findViewById(R.id.img);
        cardView= findViewById(R.id.cardView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(_2ButtonsActivity.this, _3ProgressBarActivity.class));

            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/res/layout/activity_buttons.xml");
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/java/com/example/androiders/_2ButtonsActivity.java");
            }
        });

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                vibrator.vibrate(5);
                if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    button.startAnimation(up);

                }

                else if (motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                    button.startAnimation(down);


                return true;
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