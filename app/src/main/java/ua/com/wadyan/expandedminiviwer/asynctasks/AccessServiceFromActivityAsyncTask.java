package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;

/**
 * Created by << Wad + >> on 20.08.2016.
 */
public class AccessServiceFromActivityAsyncTask extends AsyncTask<Void, Void, Void> {
    private MainActivity activity;

    public AccessServiceFromActivityAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                activity.getService().test();
                Log.d(Constants.LOG_TAG, "Activity hashcode = " + activity.hashCode()
                        + "MainService from MainActivity hashcode is " + activity.getService().hashCode());
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(Constants.LOG_TAG, "Object service don't find");
            }
        } while (activity.getService() == null);
        return null;
    }
}
