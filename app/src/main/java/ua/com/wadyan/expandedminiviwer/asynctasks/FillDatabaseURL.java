package ua.com.wadyan.expandedminiviwer.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.com.wadyan.expandedminiviwer.Constants;
import ua.com.wadyan.expandedminiviwer.activity.MainActivity;
import ua.com.wadyan.expandedminiviwer.model.Image;

/**
 * Created by << Wad + >> on 12.08.2016.
 */

public class FillDatabaseURL extends AsyncTask<Void, Void, Void> {
    private Realm realm;
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
        Log.d(Constants.LOG_TAG, "-- onPreExecute of fillDatabaseAsyncTask");


    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.d(Constants.LOG_TAG, "-- doInBackground of fillDatabaseAsyncTask");
        if(isCancelled()) return null;

        getImageURL();
//      getVideoURL();

//      publishProgress();
        return null;
    }

    private void getImageURL(){
        Log.d(Constants.LOG_TAG, "-- getImageURL of fillDatabaseAsyncTask");
        try {
            URL parentURL = new URL("http://findicons.com/pack/2843/20_free_flat_shadow_style_original_colour_icons");
            String line;
            int imageCount = 0;

            URLConnection connection = parentURL.openConnection();
            Log.d(Constants.LOG_TAG, "-- create URLConnection to " + parentURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            while ((line = reader.readLine()) != null){
//                Log.d(Constants.LOG_TAG, "-- " + reader.readLine());
//            }
            databaseInitialization();
            while ((line = reader.readLine()) != null){
                if (line.contains("img src=") && line.contains("files") && line.contains(".png") && line.contains("width")){
                    String childURL = "";

                    Log.d(Constants.LOG_TAG, "-- " + line);
                    imageCount ++;
                    for (int i = 0; i < line.length(); i++) {
                        if ("=".equals(line.charAt(i))){
                            childURL = extractURL(line, i);
                        }
                        break;
                    }
                    createImageItem(childURL, imageCount); //TODO
                }
            }
            Log.d(Constants.LOG_TAG, "-- Created " + imageCount + " images instances");

        } catch (Exception e){
            e.printStackTrace();
            Log.d(Constants.LOG_TAG, "-- exception: " + e);
        }
    }

    private String extractURL(String line, int i){
        String childURL = "";
        i += 2;
        while (line.charAt(i) != "\"".charAt(0)){
            childURL += line.charAt(i);
            i++;
        }
        Log.d(Constants.LOG_TAG, "-- childURL = " + childURL);
        return childURL;
    }


    private void createImageItem(String childURL, int imageCount) {
        RealmResults<Image> allImagesList;
        int currentImageCount;

        try{
            currentImageCount = realm.where(Image.class).findAll().size();
        } catch (NullPointerException e){
            currentImageCount = 0;
            e.printStackTrace();
        }

        Image imageInstance = new Image();
        imageInstance.setId(currentImageCount + 1);
        imageInstance.setName("Image#" + imageCount);
        imageInstance.setStringURL(childURL);

        realm.beginTransaction();
        realm.copyToRealm(imageInstance);
        realm.commitTransaction();

        allImagesList = realm.where(Image.class).findAll();
        Log.d(Constants.LOG_TAG, "Number of images in realmDatabase is " + allImagesList.size());
    }

    private void databaseInitialization(){
        Realm.init(activity); // Initialize Realm
        realm = Realm.getDefaultInstance(); // Get a Realm instance for this thread
        Log.d(Constants.LOG_TAG, "Initialize Realm");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(Constants.LOG_TAG, "End of mainAsyncTask");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
//        if(activity != null){
//        }
    }
}
