package ua.com.wadyan.expandedminiviwer.Listeners;

import android.view.View;

import ua.com.wadyan.expandedminiviwer.adapters.RecyclerViewAdapter;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class DeleteButtonListener implements View.OnClickListener{
    private RecyclerViewAdapter adapter;
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public void setAdapter(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        adapter.deleteView(object);
    }
}