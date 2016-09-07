package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.adapters.RecyclerViewAdapter;

/**
 * Created by << Wad + >> on 06.09.2016.
 */

public class AddViewAsyncTask extends AsyncTask<Void, Void, Void> {
    RecyclerViewAdapter adapter;

    public AddViewAsyncTask(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(Constants.LOG_TAG, "Add 1 View to main screen #" + i + ", adapter hashCode is " + adapter.hashCode());
//            adapter.notifyItemInserted(adapter.getItemCount());
        }


        return null;
    }
}
