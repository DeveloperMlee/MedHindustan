package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class RequestMedicine extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText edtNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_medicine);
        Toolbar toolbar = findViewById(R.id.reqToolbar);
        setSupportActionBar(toolbar);
        edtNumber=findViewById(R.id.edtNumber);
        //get full number
//        ccp.getFullNumberWithPlus().replace("","")
        ccp=findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(edtNumber);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}