package com.example.lenovo.recyclerviewexample;

/**
 * Created by lenovo on 2/20/2018.
 */

public class ExampleItem {
    private String mImageUrl;
    private String mCreator;

    public ExampleItem(String imageUrl, String creator) {
        mImageUrl = imageUrl;
        mCreator = creator;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }
}
