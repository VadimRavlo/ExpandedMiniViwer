package ua.com.wadyan.expandedminiviwer.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by << Wad + >> on 01.10.2016.
 */

public class Image extends RealmObject {
    @PrimaryKey private long id;
    private String name;
    private String stringURL;
    private String image; //TODO

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringURL() {
        return stringURL;
    }

    public void setStringURL(String stringURL) {
        this.stringURL = stringURL;
    }
}