package com.coolweather.android;


//import android.app.Fragment;
import android.support.v4.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Vol.3 on 2019/12/15.
 */

public class pageAdapter extends FragmentPagerAdapter {
    private String[] list = {"头条","娱乐","体育","第四个"};

    private Fragment[] fragments = new Fragment[]{new MapFragment(), new WeatherFragment(), new HistoryFragment(),new SettingFragment()};

    public pageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return 4;
    }

    public  CharSequence getPageTitle(int position){
        return list[position];
    }
}
