package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ReminderList extends AppCompatActivity {

    Button addRemind;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_list);
        Toolbar toolbar = findViewById(R.id.reListToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        addRemind=findViewById(R.id.addNewRem);
        animation= AnimationUtils.loadAnimation(this,R.anim.fadein);
        addRemind.setOnClickListener(v -> {
            v.startAnimation(animation);
            startActivity(new Intent(getApplicationContext(),Reminder.class));
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}