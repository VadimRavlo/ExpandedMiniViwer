package ua.com.wadyan.expandedminiviwer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.com.wadyan.expandedminiviwer.R;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String[] dataSet;
    private int pageNumber;

    public RecyclerViewAdapter(String[] dataSet, int pageNumber) {
        this.dataSet = dataSet;
        this.pageNumber = pageNumber;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        int resourse = 0;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (pageNumber){
            case 0:
                resourse = getMyLayoutResourse();
                break;
            case 1:
                resourse = R.layout.grid_item_image_box;
                break;
            case 2:
                resourse = R.layout.grid_item_video_box;
                break;
            default:
                break;
        }
        v = layoutInflater.inflate(resourse, parent, false);
        return new ViewHolder(v);
    }

    int getMyLayoutResourse(){
        int resourse = 0;

        resourse = R.layout.grid_item_image_box; //TODO

        return resourse;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = "";
        switch (pageNumber){
            case 0:
                s = "Element ";

                break;
            case 1:
                s = "Image ";
//                dataSet[position]; TODO
                break;
            case 2:
                s = "Video ";
//                dataSet[position]; TODO
                break;
            default:
                break;
        }
        holder.tvBox.setText(s + position);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }




}

