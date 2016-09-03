package ua.com.wadyan.expandedminiviwer.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.R;

/**
 * Created by << Wad + >> on 02.09.2016.
 */

public class PageFragment extends Fragment {

    private int pageNumber;
    private int backgroundColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(Constants.ARG_PAGE_NUMBER);
        Random random = new Random();
        backgroundColor = Color.argb(40, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        TextView tvPage = (TextView) view.findViewById(R.id.tv_page);
        tvPage.setText("This is super mega page #" + pageNumber);
        tvPage.setBackgroundColor(backgroundColor);
        return view;
    }
}
