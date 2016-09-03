package ua.com.wadyan.expandedminiviwer.service;

import android.os.Binder;

import ua.com.wadyan.expandedminiviwer.service.MainService;

/**
 * Created by << Wad + >> on 20.08.2016.
 */
public class MainBinder extends Binder {
    private MainService service;

    public MainBinder(MainService service) {
        this.service = service;
    }

    public MainService getService(){
        return service;
    }
}
