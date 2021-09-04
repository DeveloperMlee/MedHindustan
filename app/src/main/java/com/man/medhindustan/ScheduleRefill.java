package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.RadioGroup;

public class ScheduleRefill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_refill);

        Toolbar toolbar = findViewById(R.id.schToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        RadioGroup rb = (RadioGroup) findViewById(R.id.rbGrp);
//
//        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//
//                    case R.id.rbdHindi:
//                        Lan="Hin";
//                        StartNewActivity(Lan);
//                        break;
//                    case R.id.rbdBan:
//                        Lan="Ban";
//
//                        StartNewActivity(Lan);
//                        break;
//                    case R.id.rbdEng:
//                        Lan="Eng";
//                        StartNewActivity(Lan);
//                        break;
//                }
//            }
//
//        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}