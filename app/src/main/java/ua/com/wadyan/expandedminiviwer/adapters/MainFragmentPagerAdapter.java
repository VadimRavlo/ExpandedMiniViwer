package ua.com.wadyan.expandedminiviwer.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.fragments.PageFragment;

/**
 * Created by << Wad + >> on 02.09.2016.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    public MainFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return newInstancePageFragment(position);
    }

    PageFragment newInstancePageFragment(int position){
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(Constants.ARG_PAGE_NUMBER, position);
        pageFragment.setArguments(arguments);

        return pageFragment;
    }

    @Override
    public int getCount() {
        return Constants.PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String s;
        switch (position){
            case 0:
                s = "All";
                break;
            case 1:
                s = "Images";
                break;
            case 2:
                s = "Videos";
                break;
            default:
                s = "";
                break;
        }
        return s;
    }
}