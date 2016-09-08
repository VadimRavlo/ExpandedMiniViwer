package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.adapters.RecyclerViewAdapter;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class AsyncTaskAddView extends AsyncTask<Void, Void, Void> {
    RecyclerViewAdapter adapter;
    ArrayList<Object> dataSet;

    public AsyncTaskAddView(RecyclerViewAdapter adapter, ArrayList<Object> dataSet) {
        this.adapter = adapter;
        this.dataSet = dataSet;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < dataSet.size(); i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                publishProgress();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(Constants.LOG_TAG, "Add 1 View to main screen #" + i + ", adapter hashCode is " + adapter.hashCode());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        adapter.deleteView(dataSet.get(0)); //TODO
    }
}
