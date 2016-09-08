package ua.com.wadyan.expandedminiviwer.Listeners;

import android.support.v4.view.ViewPager;
import android.util.Log;

import ua.com.wadyan.expandedminiviwer.Constants;

/**
 * Created by << Wad + >> on 07.09.2016.
 */

public class MainOnPageChangeListener implements ViewPager.OnPageChangeListener {
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

}
