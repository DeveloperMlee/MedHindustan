package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class AskQuestion extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText edtNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
        Toolbar toolbar = findViewById(R.id.AskToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtNumber=findViewById(R.id.edtNumberQue);
        //get full number
//        ccp.getFullNumberWithPlus().replace("","")
        ccp=findViewById(R.id.ccpQue);
        ccp.registerCarrierNumberEditText(edtNumber);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}