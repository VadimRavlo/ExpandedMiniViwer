package ua.com.wadyan.expandedminiviwer.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.R;
import ua.com.wadyan.expandedminiviwer.adapters.RecyclerViewAdapter;

/**
 * Created by << Wad + >> on 02.09.2016.
 */

public class PageFragment extends Fragment {

    private int pageNumber;
    private int backgroundColor;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    public int getPageNumber() {
        return pageNumber;
    }

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

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        rvLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(rvLayoutManager);

        rvAdapter = new RecyclerViewAdapter(getDataSet(pageNumber), pageNumber);
        recyclerView.setAdapter(rvAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        TextView tvPage = (TextView) view.findViewById(R.id.tv_page);
        switch (pageNumber){
            case Constants.TAB_ALL:
                tvPage.setText(R.string.subtitle_page_all_views);
                break;
            case Constants.TAB_IMAGES:
                tvPage.setText(R.string.subtitle_page_images);
                break;
            case Constants.TAB_VIDEOS:
                tvPage.setText(R.string.subtitle_page_videos);
                break;
            default:
                break;
        }
        tvPage.setBackgroundColor(backgroundColor);

        return view;
    }

    //TODO
    ArrayList<Object> getDataSet(int pageNumber){
        ArrayList<Object> dataSet = new ArrayList<>();
        int objectsCount = 0;
        switch (pageNumber){
            case Constants.TAB_ALL:
                objectsCount = 98;
                break;
            case Constants.TAB_IMAGES:
                objectsCount = 89;
                break;
            case Constants.TAB_VIDEOS:
                objectsCount = 9;
                break;
            default:
                break;
        }
        for (int i = 0; i < objectsCount; i++) {
            dataSet.add(new Object());
        }
        return dataSet;
    }
}
