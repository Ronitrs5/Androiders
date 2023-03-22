package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar cpb, hpb;
    Button cbtn, hbtn;

    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        cbtn= findViewById(R.id.circularbtn);
        hbtn= findViewById(R.id.horizontalbtn);
        cpb= findViewById(R.id.cirpb);
        hpb= findViewById(R.id.horpb);

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
    }


}
