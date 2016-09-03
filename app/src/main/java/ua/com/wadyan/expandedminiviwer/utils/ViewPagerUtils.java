package ua.com.wadyan.expandedminiviwer.utils;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;
import ua.com.wadyan.expandedminiviwer.adapters.MainFragmentPagerAdapter;

/**
 * Created by << Wad + >> on 02.09.2016.
 */

public class ViewPagerUtils {

    public static void setAdapterAndListener(MainActivity activity){
        PagerAdapter pagerAdapter;

        pagerAdapter = new MainFragmentPagerAdapter(activity.getSupportFragmentManager());
        activity.getMainViewPager().setAdapter(pagerAdapter);

        activity.getMainViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(Constants.LOG_TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
