package ua.com.wadyan.expandedminiviwer.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;
import ua.com.wadyan.expandedminiviwer.R;

/**
 * Created by << Wad + >> on 18.08.2016.
 */
public class MainService extends Service {

    private ExecutorService executorService;
    private MainBinder iBinder = new MainBinder(this);
    private Timer timer;
    private TimerTask timerTask;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    private int notificationId;
    private int numberAddedObject;
    private Intent resultIntent;
    private PendingIntent resultPendingIntent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.LOG_TAG, "MainService onCreate");

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationBuilder = new NotificationCompat.Builder(this);

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.d(Constants.LOG_TAG, "Add 1 object to DB per minute");
                //:TODO
                numberAddedObject += 1;
                sendNotification();
            }
        };
        timer.schedule(timerTask, 500, 10000); //:TODO

        executorService = Executors.newFixedThreadPool(1);
    }

    void sendNotification(){
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Extended MiniViewer")
                .setContentText("Add " + numberAddedObject + " object to DB")
                .setContentInfo("<< Wad + >>");
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_MAX);

        resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra(Constants.PARAM_SERVICE_RESULT_ACTIVITY, numberAddedObject);

        // Adds the back stack for the Intent (but not the Intent itself) and adds the Intent that
        // starts the Activity to the top of the stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(notificationId, notificationBuilder.build());
        Log.d(Constants.LOG_TAG, "Send notification, notificationId = " + notificationId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constants.LOG_TAG, "MainService onStartCommand");

        MyRun myRun = new MyRun(this, startId);
        executorService.execute(myRun);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.LOG_TAG, "MainService onBind");
        return iBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(Constants.LOG_TAG, "MainService onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.LOG_TAG, "MainService onUnbind");
        return true; //run onRebind after first onUnbind;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.LOG_TAG, "MainService onDestroy");
    }

    public void test(){
        Log.d(Constants.LOG_TAG, "Test text from mainService object (run from activity)");
    }
}
