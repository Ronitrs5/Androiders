package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class _2ButtonsActivity extends AppCompatActivity {
    Button next, back;

    ProgressBar p1,p2,p3,p4,p5;

    ImageView imageView;
    CardView cardView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        next= findViewById(R.id.BTNnext);
        back= findViewById(R.id.BTNback);


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


//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//
//                        p1.setVisibility(View.VISIBLE);
//                        p2.setVisibility(View.VISIBLE);
//                        p3.setVisibility(View.VISIBLE);
//                        p4.setVisibility(View.VISIBLE);
//                        p5.setVisibility(View.VISIBLE);
//
//                        next.setVisibility(View.INVISIBLE);
//                        back.setVisibility(View.INVISIBLE);
//                        imageView.setVisibility(View.INVISIBLE);
//                        textView.setVisibility(View.INVISIBLE);
//                        cardView.setVisibility(View.INVISIBLE);
//
//
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                finish();
//
//                            }
//                        },5000);
//
//                    }
//                },0);
            }
        });
    }
}