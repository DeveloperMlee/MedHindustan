package com.man.medhindustan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductOverView extends AppCompatActivity {
    Animation animation;
    ImageView imgPro;
    TextView medTitle,rsPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_over_view);
        Toolbar toolbar=findViewById(R.id.proOverTool);
        setSupportActionBar(toolbar);
        imgPro=findViewById(R.id.imgProPreview);
        medTitle=findViewById(R.id.txtMedicineTitle);
        rsPrice=findViewById(R.id.txtRsPrice);
//        String str=getIntent().getStringExtra("title");
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        animation= AnimationUtils.loadAnimation(this,R.anim.fadein);
        int imgInt=getIntent().getIntExtra("intImg",0);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imgPro.setImageResource(imgInt);
        medTitle.setText(getIntent().getStringExtra("title"));
        rsPrice.setText(getIntent().getStringExtra("price"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart_search, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}