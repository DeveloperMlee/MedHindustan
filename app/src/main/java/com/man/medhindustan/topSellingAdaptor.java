package com.man.medhindustan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class topSellingAdaptor extends PagerAdapter {
    List<TopSelling>topSellingList;
    Context context;

    public topSellingAdaptor(List<TopSelling> topSellingList, Context context) {
        this.topSellingList = topSellingList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return topSellingList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.top_selling_item,container,false);

        ImageView imgTop=view.findViewById(R.id.imgTopSelling);
        TextView txtTitle=view.findViewById(R.id.txtTitle);
        TextView txtTopPrice=view.findViewById(R.id.txtTopPrice);


        imgTop.setImageResource(topSellingList.get(position).getImg());
        txtTitle.setText(topSellingList.get(position).getTitle());
        txtTopPrice.setText(topSellingList.get(position).getPrice().toString());
        view.setOnClickListener(v -> {
            Animation animation= AnimationUtils.loadAnimation(context,R.anim.fadein);
            v.startAnimation(animation);
            Intent todayIntent=new Intent(context,ProductOverView.class);
            todayIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            todayIntent.putExtra("intImg",topSellingList.get(position).getImg());
            todayIntent.putExtra("title",topSellingList.get(position).getTitle());
            todayIntent.putExtra("price",topSellingList.get(position).getPrice().toString());
            context.startActivity(todayIntent);

        });


        container.addView(view,position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
