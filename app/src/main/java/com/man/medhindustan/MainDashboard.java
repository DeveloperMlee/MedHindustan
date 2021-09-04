package com.man.medhindustan;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainDashboard extends Fragment {
    ViewPager topSellingViewPager,todaySpecialViewPager,shopCatViewPager;
    List<TopSelling> topSellingList;
    List<ShopByCatModel>shopByCatModelList;
    ShopByCatAdaptor shopByCatAdaptor;
    topSellingAdaptor topSellingAdaptor;
    List<TodaySpecial>todaySpecialList;
    CardView docCall,whatsApp;
    Animation animation;
    String phoneNumber="198";
    String number="9609503000";
    TodayAdaptor todayAdaptor;
    Button uploadNow;
    LinearLayout scheduleRefill,shopByCat,reqMed,mngReminder,askQue;
    public MainDashboard() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view =inflater.inflate(R.layout.fragment_main_dashboard, container, false);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        animation= AnimationUtils.loadAnimation(getContext(),R.anim.fadein);
        uploadNow=view.findViewById(R.id.uploadNow);
        reqMed=view.findViewById(R.id.reqMed);
        mngReminder=view.findViewById(R.id.mngReminder);
        askQue=view.findViewById(R.id.askQuestion);
        docCall=view.findViewById(R.id.docCall);
        whatsApp=view.findViewById(R.id.whatsApp);
        reqMed.setOnClickListener(v -> {
            v.startAnimation(animation);
            startActivity(new Intent(getContext(),RequestMedicine.class));
                }
        );
        askQue.setOnClickListener(v -> {
            v.startAnimation(animation);
            startActivity(new Intent(getContext(),AskQuestion.class));
        });
        mngReminder.setOnClickListener(v -> {
            v.startAnimation(animation);
            startActivity(new Intent(getContext(),ReminderList.class));
        });

        shopCatViewPager=view.findViewById(R.id.viewPagerShopByCart);
        LoadShopByCat();
        topSellingViewPager=view.findViewById(R.id.viewPagerTopSelling);
        LoadTopSelling();
        topSellingViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        todaySpecialViewPager=view.findViewById(R.id.viewPagerTodaySpe);
        LoadTodaySpecial();
        todaySpecialViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        uploadNow.setOnClickListener(v -> {
            v.startAnimation(animation);
            startActivity(new Intent(getContext(),UploadPrescription.class));

        });

      scheduleRefill=  view.findViewById(R.id.scheduleRefill);
      scheduleRefill.setOnClickListener(v -> {
          v.startAnimation(animation);
          startActivity(new Intent(getContext(),ScheduleRefill.class));
      });

      shopByCat=view.findViewById(R.id.shopByCat);
      shopByCat.setOnClickListener(v -> {
          v.startAnimation(animation);
          startActivity(new Intent(getContext(),Category.class));
      });

      whatsApp.setOnClickListener(v -> {
          v.startAnimation(animation);
          OpenWhatsApp();
      });
      docCall.setOnClickListener(v -> {
          v.startAnimation(animation);
          if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
              ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},11);
          }
          else
          {
              Uri uri = Uri.parse ( "tel:" +phoneNumber);
              startActivity ( new Intent ( Intent.ACTION_CALL , uri ) );
          }

      });
        return view;
    }

    private void OpenWhatsApp() {
        String url = "https://api.whatsapp.com/send?phone="+91+" "+number;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void LoadShopByCat() {
        shopByCatModelList=new ArrayList<>();
        shopByCatModelList.add(new ShopByCatModel(R.drawable.diabetes,"Diabetes"));
        shopByCatModelList.add(new ShopByCatModel(R.drawable.ayur,"Ayurveda"));
        shopByCatModelList.add(new ShopByCatModel(R.drawable.featured,"Featured"));
        shopByCatModelList.add(new ShopByCatModel(R.drawable.per,"Personal \nCare"));
        shopByCatModelList.add(new ShopByCatModel(R.drawable.ffitness,"Fitness & \nSupplements"));
        shopByCatModelList.add(new ShopByCatModel(R.drawable.health,"Health \nCare"));
        shopByCatAdaptor=new ShopByCatAdaptor(shopByCatModelList,getContext());
        shopCatViewPager.setAdapter(shopByCatAdaptor);
        shopCatViewPager.setPadding(20,0,430,0);
        shopCatViewPager.setPageMargin(20);
    }

    private void LoadTodaySpecial() {
        todaySpecialList=new ArrayList<>();
        todaySpecialList.add(new TodaySpecial(R.drawable.protein,"Horlicks Growth Plus Powder",500.00));
        todaySpecialList.add(new TodaySpecial(R.drawable.celol,"Celol Capsule",300.00));
        todaySpecialList.add(new TodaySpecial(R.drawable.protein,"Horlicks Growth Plus Powder",500.00));
        todayAdaptor=new TodayAdaptor(todaySpecialList,getContext());
        todaySpecialViewPager.setAdapter(todayAdaptor);
        todaySpecialViewPager.setPadding(20,0,430,0);
        todaySpecialViewPager.setPageMargin(20);
    }

    private void LoadTopSelling() {
        topSellingList=new ArrayList<>();
        topSellingList.add(new TopSelling(R.drawable.celol,"Celol Capsule",120.00));
        topSellingList.add(new TopSelling(R.drawable.mask,"Safekind N95 Mask",120.00));
        topSellingList.add(new TopSelling(R.drawable.celol,"Celol Capsule",120.00));
        topSellingAdaptor=new topSellingAdaptor(topSellingList,getContext());
        topSellingViewPager.setAdapter(topSellingAdaptor);
        topSellingViewPager.setPadding(20,0,430,0);
        topSellingViewPager.setPageMargin(20);

    }
}