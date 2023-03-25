package com.example.androiders;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class _5ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_scroll_view);

        Button next = (Button) findViewById(R.id.BTNnext);

        ImageView android = (ImageView) findViewById(R.id.img);


        Button back = (Button) findViewById(R.id.BTNback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(_5ScrollViewActivity.this, _6ToastActivity.class));
            }
        });

        android.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                next.setVisibility(View.VISIBLE);
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

    private void showDialogBox() {

        AlertDialog.Builder builder= new AlertDialog.Builder(_5ScrollViewActivity.this, R.style.AlertDialogTheme);
        View view= LayoutInflater.from(_5ScrollViewActivity.this).inflate(R.layout.dialoguebox_bk, (ConstraintLayout)findViewById(R.id.dialogbk));
        builder.setView(view);
        final AlertDialog alertDialog= builder.create();
        view.findViewById(R.id.dialogyesbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                startActivity(new Intent(_5ScrollViewActivity.this, QuizActivity.class));
            }
        });




        view.findViewById(R.id.dialognobtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

}