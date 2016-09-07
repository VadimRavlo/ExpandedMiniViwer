package ua.com.wadyan.expandedminiviwer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import ua.com.wadyan.expandedminiviwer.R;
import ua.com.wadyan.expandedminiviwer.Listeners.DeleteButtonListener;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public VideoView videoView;
    public TextView textView;
    public Button deleteButton;
    public DeleteButtonListener deleteButtonListener;


    public ViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tv_box);
        imageView = (ImageView) itemView.findViewById(R.id.image_box_iv);
        videoView = (VideoView) itemView.findViewById(R.id.video_box_vv);
        deleteButton = (Button) itemView.findViewById(R.id.btn_remove);
        deleteButtonListener = new DeleteButtonListener();
        deleteButton.setOnClickListener(deleteButtonListener);
    }
}