package ua.com.wadyan.expandedminiviwer.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by << Wad + >> on 01.10.2016.
 */

public class Video extends RealmObject {
    @PrimaryKey private int id;
    private String name;
    private String URL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
