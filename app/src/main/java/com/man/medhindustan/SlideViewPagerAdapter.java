package com.man.medhindustan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class SlideViewPagerAdapter extends PagerAdapter {
    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
         return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);

        TextView skip=view.findViewById(R.id.txtSkip);
        ImageView onImage=view.findViewById(R.id.onImg);
        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);
        ImageView ind4=view.findViewById(R.id.ind4);
        ImageView ind5=view.findViewById(R.id.ind5);
        TextView onTitle=view.findViewById(R.id.onTitle);
        TextView onDes=view.findViewById(R.id.onDes);
        TextView next=view.findViewById(R.id.arNext);
        TextView nextAct=view.findViewById(R.id.nextAct);

        skip.setOnClickListener(v -> {
            Intent intent=new Intent(ctx,Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(intent);
        });
        next.setOnClickListener(v -> {
            Slide.viewPager.setCurrentItem(position+1);
        });
        nextAct.setOnClickListener(v -> {
            Intent intent=new Intent(ctx,Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(intent);
        });
        switch (position)
        {
            case 0:
                onImage.setImageResource(R.drawable.otc);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                onTitle.setText(R.string.upload_prescription);
                onDes.setText(R.string.des_up_pres);
                break;
            case 1:
                onImage.setImageResource(R.drawable.otc);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                onTitle.setText(R.string.otc_wellness);
                onDes.setText(R.string.ondes);
                break;

            case 2:
                onImage.setImageResource(R.drawable.ic_great);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                onTitle.setText(R.string.offers);
                onDes.setText(R.string.des_dis);

                break;
            case 3:
                onImage.setImageResource(R.drawable.phar);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.selected);
                ind5.setImageResource(R.drawable.unselected);
                onTitle.setText(R.string.ask_our_pharmacist);
                onDes.setText(R.string.des_ask_phar);
                break;
            case 4:
                onImage.setImageResource(R.drawable.otc);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.selected);
                onTitle.setText(R.string.home_delivery);
                onDes.setText(R.string.home_des);
                skip.setVisibility(View.INVISIBLE);
                next.setVisibility(View.GONE);
                nextAct.setVisibility(View.VISIBLE);
                break;

        }
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
