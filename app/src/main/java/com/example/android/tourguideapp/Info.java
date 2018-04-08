package com.example.android.tourguideapp;

/**
 * {@link Info} represents the info about point of interest in Frankfurt.
 * It contains a title (the name), a subtitle (short or long description), an image for that point
 * of interest and in some cases an arrow image that let's the user know that list item can be
 * clicked on (this version doesn't yet support more specific details about that point of interest).
 */
public class Info {

    /** Title for the info */
    private String mTitle;

    /** Subtitle for the info */
    private String mSubtitle;

    /** Image resource ID for the info */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mImageResourceIdArrow = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this info */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Info object.
     *
     * @param title is title of the info displayed
     * @param subtitle is the subtitle displayed
     * @param imageResourceId is the drawable resource ID for the image associated with the info
     * @param imageResourceIdArrow is the drawable resource ID for the Arrow image displayed on
     *                             the right of the info
     */
    public Info(String title, String subtitle, int imageResourceId, int imageResourceIdArrow) {
        mTitle = title;
        mSubtitle = subtitle;
        mImageResourceId = imageResourceId;
        mImageResourceIdArrow = imageResourceIdArrow;
    }

    /**
     * Create a new Info object.
     *
     * @param title is title of the info displayed
     * @param subtitle is the subtitle displayed
     * @param imageResourceIdArrow is the drawable resource ID for the Arrow image displayed on
     *                             the right of the info
     */
    public Info(String title, String subtitle, int imageResourceIdArrow) {
        mTitle = title;
        mSubtitle = subtitle;
        mImageResourceIdArrow = imageResourceIdArrow;
    }

    /**
     * Create a new Info object.
     *
     * @param title is title of the info displayed
     * @param subtitle is the subtitle displayed
     */
    public Info(String title, String subtitle) {
        mTitle = title;
        mSubtitle = subtitle;
    }

    /**
     * Get the title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the subtitle.
     */
    public String getSubtitle() {
        return mSubtitle;
    }

    /**
     * Return the image resource ID of the info (photo on the left).
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the image resource ID of arrow image (photo on the right).
     */
    public int getImageResourceIdArrow() {
        return mImageResourceIdArrow;
    }

    /**
     * Returns whether or not there is an image for this info.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an Arrow image for this info.
     */
    public boolean hasImageArrow() {
        return mImageResourceIdArrow != NO_IMAGE_PROVIDED;
    }
}