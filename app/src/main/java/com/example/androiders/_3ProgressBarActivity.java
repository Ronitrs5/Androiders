package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class _3ProgressBarActivity extends AppCompatActivity {
    ProgressBar cpb, hpb;
    Button cbtn, hbtn, cusbtn;
    Button i1, i2;

    LottieAnimationView cuspb;

    int count=0;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        cbtn= findViewById(R.id.circularbtn);
        hbtn= findViewById(R.id.horizontalbtn);
        cpb= findViewById(R.id.cirpb);
        hpb= findViewById(R.id.horpb);
        cuspb= findViewById(R.id.cuspb);
        cusbtn= findViewById(R.id.custombtn);
        imageView= findViewById(R.id.img2);

        Button next=(Button) findViewById(R.id.BTNnext);
        Button back= (Button) findViewById(R.id.BTNback);

        i1= findViewById(R.id.xmlbtn);
        i2= findViewById(R.id.javabtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(_3ProgressBarActivity.this, _4LinearLayoutActivity.class));

            }
        });

        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cpb.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cpb.setVisibility(View.INVISIBLE);

                    }
                },4000);

            }
        });

        cusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cuspb.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cuspb.setVisibility(View.INVISIBLE);

                    }
                },4000);

            }
        });

        hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hpb.setVisibility(View.VISIBLE);


                Timer t= new Timer();
                TimerTask tt= new TimerTask() {
                    @Override
                    public void run() {
                        count++;
                        hpb.setProgress(count);

                        if (count==100){
                            t.cancel();
                            count=0;
                            hpb.setVisibility(View.INVISIBLE);

                        }

                    }
                };

                t.schedule(tt, 0, 40);
            }

        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/res/layout/activity_progress_bar.xml");
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/java/com/example/androiders/_3ProgressBarActivity.java");
            }
        });

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                imageView.setVisibility(View.GONE);
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
