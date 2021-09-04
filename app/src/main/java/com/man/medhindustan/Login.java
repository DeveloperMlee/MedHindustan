package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class Login extends AppCompatActivity {
    EditText edtNumber;
    CountryCodePicker ccp;
    FirebaseAuth mAuth;
    Button login;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtNumber=findViewById(R.id.edtNumber);
        login=findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        ccp=findViewById(R.id.ccpLogin);
        ccp.registerCarrierNumberEditText(edtNumber);

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        login.setOnClickListener(v -> {
            animation   = AnimationUtils.loadAnimation(this,R.anim.fadein);
            v.startAnimation(animation);
            if(edtNumber.getText().toString().isEmpty()){
                Toast.makeText(this, "Blank Field Can Not Be Processed", Toast.LENGTH_LONG).show();
            }
            else if (edtNumber.getText().toString().length()<10){
                Toast.makeText(this, "PLease enter valid number", Toast.LENGTH_LONG).show();
            }

            else {
                Intent intent=new Intent(getApplicationContext(),Verification.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace("",""));
                startActivity(intent);
                finish();

            }
        });
    }
}