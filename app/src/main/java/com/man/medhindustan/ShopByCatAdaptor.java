package com.man.medhindustan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ShopByCatAdaptor  extends PagerAdapter {

    List<ShopByCatModel> shopByCatModelList;
    Context ct;

    public ShopByCatAdaptor(List<ShopByCatModel> shopByCatModelList, Context ct) {
        this.shopByCatModelList = shopByCatModelList;
        this.ct = ct;
    }

    @Override
    public int getCount() {
        return shopByCatModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(ct).inflate(R.layout.shop_by_cat,container,false);

        ImageView imgShopCat=view.findViewById(R.id.imgShopByCat);
        TextView shopByTitle=view.findViewById(R.id.txtShopByTitle);
        imgShopCat.setImageResource(shopByCatModelList.get(position).getImg());
        shopByTitle.setText(shopByCatModelList.get(position).getTitle());

        container.addView(view,position);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
