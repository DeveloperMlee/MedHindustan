package com.man.medhindustan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verification extends AppCompatActivity {
    EditText edtOtp;
    Button btnVeri;
    String otpId;
    private LinearLayout  progressBar;
    Animation animation;
    private FirebaseAuth mAuth;
    String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        phoneNumber=getIntent().getStringExtra("mobile").toString();
        edtOtp=findViewById(R.id.edtOtp);
        progressBar=findViewById(R.id.proGress);
        btnVeri=findViewById(R.id.btnVerify);
        mAuth= FirebaseAuth.getInstance();
        initiateOtp();
        btnVeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtOtp.getText().toString().isEmpty()){
                    Toast.makeText(Verification.this, "Blank Field Can Not Be Processed", Toast.LENGTH_LONG).show();
                }
                else if(edtOtp.getText().toString().length()!=6){
                    Toast.makeText(Verification.this, "Invalid OTP", Toast.LENGTH_LONG).show();
                }
                else {
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpId,edtOtp.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }
            }
        });
    }
    private void initiateOtp() {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                otpId=s;
                                Toast.makeText(getApplicationContext(), "The Code is sent to your number", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                                progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        } else {

                            Toast.makeText(getApplicationContext(), "Sign In Code Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}