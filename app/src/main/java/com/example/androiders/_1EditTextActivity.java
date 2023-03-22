package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class _1EditTextActivity extends AppCompatActivity {

    Button next, back;
    Button i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        next= findViewById(R.id.BTNnext);
        back= findViewById(R.id.BTNback);
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
                gotoUrl("https://github.com/Ronitrs5/Androiders/blob/master/app/src/main/java/com/example/androiders/EditTextActivity.java");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}