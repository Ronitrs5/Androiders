package com.example.androiders.drawerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiders.QuizActivity;
import com.example.androiders.R;
import com.example.androiders._1EditTextActivity;
import com.example.androiders._2ButtonsActivity;
import com.example.androiders._3ProgressBarActivity;
import com.example.androiders._4LinearLayoutActivity;
import com.example.androiders._5ScrollViewActivity;
import com.example.androiders._6ToastActivity;

public class ContentActivity extends AppCompatActivity {

    CardView c1,c2,c3,c4,c5,c6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        c1= findViewById(R.id.chap1);
        c2= findViewById(R.id.chap2);
        c3= findViewById(R.id.chap3);
        c4= findViewById(R.id.chap4);
        c5= findViewById(R.id.chap5);
        c6= findViewById(R.id.chap6);

        c1.setOnClickListener(view -> startActivity(new Intent(ContentActivity.this, _1EditTextActivity.class)));
        c2.setOnClickListener(view -> startActivity(new Intent(ContentActivity.this, _2ButtonsActivity.class)));
        c3.setOnClickListener(view -> startActivity(new Intent(ContentActivity.this, _3ProgressBarActivity.class)));
        c4.setOnClickListener(view -> startActivity(new Intent(ContentActivity.this, _4LinearLayoutActivity.class)));
        c5.setOnClickListener(view -> startActivity(new Intent(ContentActivity.this, _5ScrollViewActivity.class)));
        c6.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), _6ToastActivity.class)));

        ImageView backimg= (ImageView) findViewById(R.id.profilebackimg);
        backimg.setOnClickListener(view -> finish());

        TextView taketest= (TextView) findViewById(R.id.takeTestTXT);
        taketest.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), QuizActivity.class)));


    }
}