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
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class TodayAdaptor extends PagerAdapter {

    List<TodaySpecial> todaySpecialList;
    Context ctx;

    public TodayAdaptor(List<TodaySpecial> todaySpecialList, Context ctx) {
        this.todaySpecialList = todaySpecialList;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return todaySpecialList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.today_special_item,container,false);

        ImageView imgToday=view.findViewById(R.id.imgToday);
        TextView todayTitle=view.findViewById(R.id.txtTodayTitle);
        TextView todayPrice=view.findViewById(R.id.txtTodayPrice);

        imgToday.setImageResource(todaySpecialList.get(position).getImg());
        todayTitle.setText(todaySpecialList.get(position).getTitle());
        todayPrice.setText(todaySpecialList.get(position).getPrice().toString());

        view.setOnClickListener(v -> {
            Animation animation= AnimationUtils.loadAnimation(ctx,R.anim.fadein);
            v.startAnimation(animation);
            Intent todayIntent=new Intent(ctx,ProductOverView.class);
            todayIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            todayIntent.putExtra("intImg",todaySpecialList.get(position).getImg());
            todayIntent.putExtra("title",todaySpecialList.get(position).getTitle());
            todayIntent.putExtra("price",todaySpecialList.get(position).getPrice().toString());
            ctx.startActivity(todayIntent);

        });
        container.addView(view,position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
