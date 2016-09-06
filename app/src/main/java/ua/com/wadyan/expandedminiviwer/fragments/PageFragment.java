package ua.com.wadyan.expandedminiviwer.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

//        rvLayoutManager = new LinearLayoutManager(getActivity());
        rvLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(rvLayoutManager);

        rvAdapter = new RecyclerViewAdapter(getDataSet(), pageNumber);
        recyclerView.setAdapter(rvAdapter);

        TextView tvPage = (TextView) view.findViewById(R.id.tv_page);
        switch (pageNumber){
            case 0:
                tvPage.setText(R.string.subtitle_page_all_views);
                break;
            case 1:
                tvPage.setText(R.string.subtitle_page_images);
                break;
            case 2:
                tvPage.setText(R.string.subtitle_page_videos);
                break;
            default:
                break;
        }
        tvPage.setBackgroundColor(backgroundColor);

        return view;
    }

    String[] getDataSet(){
        String[] dataSet = new String[100];
        for (int i = 0; i < 100; i++) {
            dataSet[i] = "#" + i;
        }
        return dataSet;
    }
}
