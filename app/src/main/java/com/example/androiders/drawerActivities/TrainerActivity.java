package com.example.androiders.drawerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiders.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrainerActivity extends AppCompatActivity {

    TextView  n1, p1, e1, n2, p2, e2;
    CircleImageView i1, i2;
    ConstraintLayout layout, layout1;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        n1= findViewById(R.id.guestname1);
        p1= findViewById(R.id.guestph1);
        e1= findViewById(R.id.guestemail1);
        i1= findViewById(R.id.guestimg1);

        n2= findViewById(R.id.guestname2);
        p2= findViewById(R.id.guestph2);
        e2= findViewById(R.id.guestemail2);
        i2= findViewById(R.id.guestimg2);

        back= findViewById(R.id.profilebackimg);

        layout= findViewById(R.id.layout2);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        layout1= findViewById(R.id.layout3);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void expand2(View view) {
        int name1=(n1.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        int phone1=(p1.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        int email1=(e1.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        n1.setVisibility(name1);
        p1.setVisibility(phone1);
        e1.setVisibility(email1);

    }
    public void expand1(View view) {
        int name2=(n2.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        int phone2=(p2.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        int email2=(e2.getVisibility()==View.GONE)? View.VISIBLE :View.GONE;
        TransitionManager.beginDelayedTransition(layout1,new AutoTransition());
        n2.setVisibility(name2);
        p2.setVisibility(phone2);
        e2.setVisibility(email2);

    }
}