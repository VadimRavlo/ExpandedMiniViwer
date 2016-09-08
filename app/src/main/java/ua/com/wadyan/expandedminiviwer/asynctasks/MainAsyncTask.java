package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;

/**
 * Created by << Wad + >> on 12.08.2016.
 */

public class MainAsyncTask extends AsyncTask<Void, Void, Void> {

    private MainActivity activity;

    public void linkToActivity(MainActivity activity){
        this.activity = activity;
    }

    public void unLinkFromActivity(){
        activity = null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(Constants.LOG_TAG, "Begin of mainAsyncTask");

    }

    @Override
    protected Void doInBackground(Void... voids) {
        if(isCancelled()) return null;
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                Log.d(Constants.LOG_TAG, "i = " + i);
//                publishProgress();
            }
        } catch (Exception e){
            Log.d(Constants.LOG_TAG, e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(Constants.LOG_TAG, "End of mainAsyncTask");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        if(activity != null){
        }
    }
}
