package com.example.androiders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.androiders.drawerActivities.ContentActivity;
import com.example.androiders.drawerActivities.TrainerActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class _0MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button button;
    ImageView konfettibtn;

    private KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.main);
        navigationView = findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        button= findViewById(R.id.getStartedBTN);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_people:
                        startActivity(new Intent(_0MainActivity.this, TrainerActivity.class));
                        return true;

                    case R.id.menu_content:
                        startActivity(new Intent(_0MainActivity.this, ContentActivity.class));
                        return true;

                    case R.id.shareApp:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, "Our app is not on play-store currently.\n\nKindly ask your friend/teacher to send the apk file");
                        startActivity(Intent.createChooser(intent, "Select one"));
                        return true;

                }
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(_0MainActivity.this, _1EditTextActivity.class));
            }
        });

        konfettiView= findViewById(R.id.konfetti);
        konfettibtn= findViewById(R.id.konfettibtn);

        Shape.DrawableShape drawableShape= new Shape.DrawableShape(AppCompatResources.getDrawable(this, R.drawable.android_logo), true);

        konfettibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.VISIBLE);
                EmitterConfig emitterConfig= new Emitter(300, TimeUnit.MILLISECONDS).max(250);
                konfettiView.start(
                        new PartyFactory(emitterConfig)
                                .shapes(Shape.Circle.INSTANCE,Shape.Square.INSTANCE, drawableShape)
                                .spread(360)
                                .position(0.25,0.5,1,1)
                                .sizes( new Size(10, 10, 100))
                                .timeToLive(300).fadeOutEnabled(true).build()
                );
            }
        });

    }
}