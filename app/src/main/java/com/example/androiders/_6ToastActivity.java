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

import java.util.Objects;

public class _6ToastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6_toast);

        Button defaultToastBTN= (Button) findViewById(R.id.defaulttoast);
        Button customToastBTN= (Button) findViewById(R.id.customtoast);

        ImageView android = (ImageView) findViewById(R.id.imageView);
        Button next= (Button) findViewById(R.id.BTNnext);
        next.setVisibility(View.INVISIBLE);

        defaultToastBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(_6ToastActivity.this, "This is a default toast", Toast.LENGTH_SHORT).show();
            }
        });

        customToastBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater= getLayoutInflater();
                View layout= inflater.inflate(R.layout.custon_toast, (ViewGroup) findViewById(R.id.toast_root));
                layout.setBackgroundColor(Color.RED);
                TextView textView= layout.findViewById(R.id.customToast);
                textView.setText("This is a custom toast");
                textView.setTextColor(Color.WHITE);
                Toast toast= new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 350);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });

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
                showDialogBox();
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

        AlertDialog.Builder builder= new AlertDialog.Builder(_6ToastActivity.this, R.style.AlertDialogTheme);
        View view= LayoutInflater.from(_6ToastActivity.this).inflate(R.layout.dialoguebox_bk, (ConstraintLayout)findViewById(R.id.dialogbk));
        builder.setView(view);
        final AlertDialog alertDialog= builder.create();
        view.findViewById(R.id.dialogyesbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                startActivity(new Intent(_6ToastActivity.this, QuizActivity.class));
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