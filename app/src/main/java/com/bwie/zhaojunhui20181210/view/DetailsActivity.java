package com.bwie.zhaojunhui20181210.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bwie.zhaojunhui20181210.R;
import com.bwie.zhaojunhui20181210.fragment.HomeFragment;
import com.bwie.zhaojunhui20181210.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends FragmentActivity {

    private ViewPager pager;
    private RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        pager = findViewById(R.id.pager);
        group = findViewById(R.id.group);
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MyFragment());

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

       pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int i, float v, int i1) {

           }

           @Override
           public void onPageSelected(int i) {
               switch (i){
                   case 0:
                       group.check(R.id.button1);
                       break;
                   case 1:
                       group.check(R.id.button2);
                       break;
                       default:
                           break;
               }
           }

           @Override
           public void onPageScrollStateChanged(int i) {

           }
       });

       group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.button1:
                       pager.setCurrentItem(0);
                       break;
                   case R.id.button2:
                       pager.setCurrentItem(1);
                       break;
                       default:
                           break;
               }
           }
       });

    }
}
