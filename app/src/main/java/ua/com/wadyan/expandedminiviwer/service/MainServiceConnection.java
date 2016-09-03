package ua.com.wadyan.expandedminiviwer.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;

/**
 * Created by << Wad + >> on 18.08.2016.
 */
public class MainServiceConnection implements ServiceConnection {
    private MainActivity activity;

    public MainServiceConnection(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(Constants.LOG_TAG, "MainActivity -> MainServiceConnection onServiceConnected");
        activity.setService(((MainBinder) iBinder).getService());
        Log.d(Constants.LOG_TAG, "MainActivity get access to object mainService");
        activity.setBound(true);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d(Constants.LOG_TAG, "MainActivity -> MainServiceConnection onServiceDisconnected");
        activity.setBound(false);
    }
}
