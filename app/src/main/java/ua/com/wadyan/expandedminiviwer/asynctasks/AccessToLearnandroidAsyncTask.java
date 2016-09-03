package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;

/**
 * Created by << Wad + >> on 03.09.2016.
 */

public class AccessToLearnandroidAsyncTask extends AsyncTask<Void, Void, Void> {
    private MainActivity activity;
    private int lessonsCount;

    public AccessToLearnandroidAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("http://startandroid.ru/ru/uroki/vse-uroki-spiskom");
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null){
                if (line.contains("-uroki-") && line.contains("JFusion.articelUrl"))
                    lessonsCount += 1;
            }
            Log.d(Constants.LOG_TAG, "Lessons count of http://startandroid.ru is " + lessonsCount);

        } catch (Exception e){
            Log.d(Constants.LOG_TAG, e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(activity, "Loading of http://startandroid.ru is finished, number of lessons is " + lessonsCount, Toast.LENGTH_LONG).show();
        super.onPostExecute(aVoid);
    }
}
