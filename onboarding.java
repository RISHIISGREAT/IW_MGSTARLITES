package com.mgstarlites.jobkaro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class onboarding extends AppCompatActivity {

    ViewPager mSlideviewpager;
    LinearLayout mDotLayout;
    Button skip,next,back;


    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);


        back=findViewById(R.id.Back);
        next=findViewById(R.id.next);
        skip=findViewById(R.id.skip1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0)>0){
                    mSlideviewpager.setCurrentItem(getitem(-1),true);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getitem(0)<3){
                    mSlideviewpager.setCurrentItem(getitem(1),true);
                }else{
                    Intent i = new Intent(onboarding.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(onboarding.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        mSlideviewpager = (ViewPager) findViewById(R.id.slideviewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new ViewPagerAdapter(this);
        mSlideviewpager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSlideviewpager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) viewListner);

    }

    public void setUpindicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();


        for(int i = 0 ; i < dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {


            setUpindicator(position);
            if(position>0){
                back.setVisibility(View.VISIBLE);
            }else{
                back.setVisibility(View.INVISIBLE);
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){
        return mSlideviewpager.getCurrentItem() + i;
    }


}