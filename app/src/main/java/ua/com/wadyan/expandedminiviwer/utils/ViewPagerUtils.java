package ua.com.wadyan.expandedminiviwer.utils;

import android.support.v4.view.PagerAdapter;

import ua.com.wadyan.expandedminiviwer.Listeners.MainOnPageChangeListener;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;
import ua.com.wadyan.expandedminiviwer.adapters.MainFragmentPagerAdapter;

/**
 * Created by << Wad + >> on 02.09.2016.
 */

public class ViewPagerUtils {
    public static void setAdapterAndListener(MainActivity activity){
        PagerAdapter pagerAdapter = new MainFragmentPagerAdapter(activity.getSupportFragmentManager());
        activity.getViewPager().setAdapter(pagerAdapter);

        activity.getViewPager().addOnPageChangeListener(new MainOnPageChangeListener());
    }
}
