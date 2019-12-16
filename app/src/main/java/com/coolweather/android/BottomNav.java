package com.coolweather.android;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;



public class BottomNav extends AppCompatActivity {
    ViewPager vp = null;
    private int lastfragment = 0;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_map:
                    if(lastfragment!=0)
                    {
                        replaceFragment(new MapFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
//                        vp.setCurrentItem(0,true);
                        lastfragment=0;
                    }
                    return true;
                case R.id.nav_weather:
                    if(lastfragment!=1)
                    {
                        replaceFragment(new WeatherFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
//                        vp.setCurrentItem(1,true);
                        lastfragment=1;
                    }
                    return true;
                case R.id.nav_history:
                    if(lastfragment!=2)
                    {
                        replaceFragment(new HistoryFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
//                        vp.setCurrentItem(2,true);
                        lastfragment=2;
                    }
                    return true;
                case R.id.nav_setting:
                    if(lastfragment!=3)
                    {
                        replaceFragment(new SettingFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
//                        vp.setCurrentItem(3,true);
                        lastfragment=3;
                    }
                    return true;
                default:
                    replaceFragment(new MapFragment());//id为tab_one则第一项被点击，遂用HomeFragment替换空Fragment
//                    vp.setCurrentItem(0,true);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

//        vp = findViewById(R.id.viewPager);
//        vp.setAdapter(new pageAdapter(getSupportFragmentManager()));
//        vp.setCurrentItem(0);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment(new MapFragment());
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_empty, fragment);
        transaction.commit();
    }

}
