package ua.com.wadyan.expandedminiviwer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import ua.com.wadyan.expandedminiviwer.R;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    public ImageView ivImageBox;
    public VideoView vvVideoBox;
    public TextView tvBox;


    public ViewHolder(View itemView) {
        super(itemView);
        tvBox = (TextView) itemView.findViewById(R.id.tv_box);
        ivImageBox = (ImageView) itemView.findViewById(R.id.image_box_iv);
        vvVideoBox = (VideoView) itemView.findViewById(R.id.video_box_vv);
    }
}