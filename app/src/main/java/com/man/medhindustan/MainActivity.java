package com.man.medhindustan;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    Dialog dialog;
    PopupWindow popUp;
    DrawerLayout drawerLayout;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainDashboard()).commit();
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        nav=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        popUp = new PopupWindow(this);
        animation= AnimationUtils.loadAnimation(this,R.anim.fadein);

        nav.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.menSearch:
                    Toast.makeText(MainActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.uploadPres:
                     startActivity(new Intent(getApplicationContext(),UploadPrescription.class));
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuCategory:
                    startActivity(new Intent(getApplicationContext(),Category.class));
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuOrders:
                    Toast.makeText(MainActivity.this, " Order Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.myProfile:
                    Toast.makeText(MainActivity.this, " My Profile Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.menuAddress:
                    Toast.makeText(MainActivity.this, " Address Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuMyPre:
                    Toast.makeText(MainActivity.this, " My profile", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuResetPass:
                    Toast.makeText(MainActivity.this, " Reset Password clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuOffers:
                    Toast.makeText(MainActivity.this, "Offers Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuRefill:
                    Toast.makeText(MainActivity.this, " Refill Clicked", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.menuLogout:
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            return true;
        });

        dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.pop_up);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;
//        TextView ver=dialog.findViewById(R.id.txtSetVer);
//        ver.setText(BuildConfig.VERSION_NAME);
//        TextView date=dialog.findViewById(R.id.txtSetDate);
//        date.setText(formattedDate);
//        TextView okay=dialog.findViewById(R.id.txtOkay);
//
//        okay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return true;
    }
}