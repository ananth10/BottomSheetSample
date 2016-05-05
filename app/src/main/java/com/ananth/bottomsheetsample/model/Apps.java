package com.ananth.bottomsheetsample.model;

/**
 * Created by Babu on 5/5/2016.
 */
public class Apps {

    private int titleId;
    private int imageId;

    public Apps(int titleId, int imageId) {
        this.titleId = titleId;
        this.imageId = imageId;
    }

    public int getTitleId() {
        return titleId;
    }

    public int getImageId() {
        return imageId;
    }

}
