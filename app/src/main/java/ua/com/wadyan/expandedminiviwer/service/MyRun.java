package ua.com.wadyan.expandedminiviwer.service;

import android.util.Log;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.service.MainService;

/**
 * Created by << Wad + >> on 18.08.2016.
 */
public class MyRun implements Runnable {
    private MainService service;
    private int startId;

    public MyRun(MainService service, int startId) {
        this.service = service;
        this.startId = startId;
//        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " create");
    }

    @Override
    public void run() {
        //:TODO

        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " start");
//        stop();
    }

    void stop(){
//        Log.d(Constants.LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ") = "
//                + service.stopSelfResult(startId));
    }
}
