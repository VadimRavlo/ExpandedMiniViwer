package ua.com.wadyan.expandedminiviwer.adapters;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.R;
import ua.com.wadyan.expandedminiviwer.asynctasks.AsyncTaskDeleteView;
import ua.com.wadyan.expandedminiviwer.utils.ImageLoader;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Fragment fragment;
    private ArrayList<Object> dataSet;
    private int pageNumber; //TODO
    private AsyncTaskDeleteView asyncTaskAddView;

    public RecyclerViewAdapter(Fragment fragment, ArrayList<Object> dataSet, int pageNumber) {
        this.fragment = fragment;
        this.dataSet = dataSet;
        this.pageNumber = pageNumber;

        Log.d(Constants.LOG_TAG, "create RecyclerViewAdapter" + this.hashCode());

        int addedObjectCount = 0;
        switch (pageNumber){
            case Constants.TAB_ALL:
                addedObjectCount = 2;
                asyncTaskAddView = new AsyncTaskDeleteView(this, dataSet);
                asyncTaskAddView.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            case Constants.TAB_IMAGES:
                addedObjectCount = 1;
                break;
            case Constants.TAB_VIDEOS:
                addedObjectCount = 1;
                break;
            default:
                break;
        }
        for (int i = 0; i < addedObjectCount; i++) {
            dataSet.add(new Object());
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resource = 0;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (pageNumber){
            case Constants.TAB_ALL:
                resource = getMyLayoutResource();
                Log.d(Constants.LOG_TAG, "onCreateViewHolder AllTab");
                break;
            case Constants.TAB_IMAGES:
                resource = R.layout.grid_item_image_box;
                Log.d(Constants.LOG_TAG, "onCreateViewHolder ImagesTab");
                break;
            case Constants.TAB_VIDEOS:
                resource = R.layout.grid_item_video_box;
                Log.d(Constants.LOG_TAG, "onCreateViewHolder VideosTab");
                break;
            default:
                break;
        }
        View v = layoutInflater.inflate(resource, parent, false);
        return new ViewHolder(v);
    }

    private int getMyLayoutResource(){   //TODO
        int resource =  R.layout.grid_item_image_box;

        return resource;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object object = dataSet.get(position);
        String s = "";
        String imageURL;
        switch (pageNumber){
            case Constants.TAB_ALL:
                s = "el.";
                imageURL = "http://findicons.com/icon/download/38862/dog/128/png?id=38866";
                ImageLoader.load(fragment.getActivity(), imageURL, holder.imageView);
                Log.d(Constants.LOG_TAG, "onBindViewHolder AllTab");
                break;
            case Constants.TAB_IMAGES:
                s = "img.";
                //TODO

                Log.d(Constants.LOG_TAG, "onBindViewHolder ImagesTab");
                break;
            case Constants.TAB_VIDEOS:
                s = "vid.";
                //TODO

                Log.d(Constants.LOG_TAG, "onBindViewHolder VideosTab");
                break;
            default:
                break;
        }
        holder.textView.setText(s + position);
        holder.deleteButtonListener.setObject(object);
        holder.deleteButtonListener.setAdapter(this);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void deleteView (Object object) {
        int position = dataSet.indexOf(object);
        Log.d(Constants.LOG_TAG, "Object #" + position + " will be delete, object hashCode is "
                + object.hashCode());
        dataSet.remove(position);
        notifyItemRemoved(position);
    }
}

