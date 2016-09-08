package ua.com.wadyan.expandedminiviwer.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.R;
import ua.com.wadyan.expandedminiviwer.asynctasks.AccessServiceFromActivityAsyncTask;
import ua.com.wadyan.expandedminiviwer.asynctasks.AccessToLearnandroidAsyncTask;
import ua.com.wadyan.expandedminiviwer.asynctasks.MainAsyncTask;
import ua.com.wadyan.expandedminiviwer.service.MainService;
import ua.com.wadyan.expandedminiviwer.service.MainServiceConnection;
import ua.com.wadyan.expandedminiviwer.utils.ViewPagerUtils;

/**
 * Created by << Wad + >> on 01.08.2016.
 */

public class MainActivity extends AppCompatActivity {
    private MainAsyncTask mainAsyncTask;
    private AccessServiceFromActivityAsyncTask accessServiceFromActivityAsyncTask;
    private AccessToLearnandroidAsyncTask accessToLearnandroidAsyncTask;
    private MainServiceConnection serviceConnection;
    private Intent intentService;
    private boolean bound = false;
    private MainService service;
    @Bind(R.id.view_pager_main) ViewPager viewPager;

    public ViewPager getViewPager() {
        return viewPager;
    }

    public MainService getService() {
        return service;
    }

    public void setService(MainService service) {
        this.service = service;
    }

    public boolean isBound() {
        return bound;
    }

    public void setBound(boolean bound) {
        this.bound = bound;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        final android.support.v7.app.ActionBar bar = getSupportActionBar();

        intentService = new Intent(Constants.ACTION_RUN_MAIN_SERVICE);
        serviceConnection = new MainServiceConnection(this);

        ViewPagerUtils.setAdapterAndListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.load_startandroid:
                accessToLearnandroidAsyncTask = new AccessToLearnandroidAsyncTask(this);
                accessToLearnandroidAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        bindService(intentService, serviceConnection, BIND_AUTO_CREATE);

        accessServiceFromActivityAsyncTask = new AccessServiceFromActivityAsyncTask(this);
        accessServiceFromActivityAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        getMainAsyncTaskObject();
    }

    void getMainAsyncTaskObject(){
        mainAsyncTask =(MainAsyncTask) getLastCustomNonConfigurationInstance();
        if (mainAsyncTask == null) {
            mainAsyncTask = new MainAsyncTask();
            mainAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        mainAsyncTask.linkToActivity(this);
        Log.d(Constants.LOG_TAG, "Create or get mainAsyncTask");
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        mainAsyncTask.unLinkFromActivity();
        return mainAsyncTask;
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (!bound) return;
        unbindService(serviceConnection);
        bound = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        stopService(intentService);
        Toast.makeText(this, "Goodbye amigo !!!", Toast.LENGTH_SHORT).show();
    }
}
