package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link InfoAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Info} objects.
 */
public class InfoAdapter extends ArrayAdapter<Info>  {
    /** Resource ID for the background color for this list of infos */
    private int mColorResourceId;

    /**
     * Create a new {@link InfoAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param infos is the list of {@link Info}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of infos
     */
    public InfoAdapter(Context context, ArrayList<Info> infos, int colorResourceId) {
        super(context, 0, infos);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.info_list_item, parent, false);
        }

        // Get the {@link Info} object located at this position in the list
        Info currentInfo = getItem(position);

        // Find the TextView in the info_list_item.xml layout with the ID subtitle_text_view.
        TextView subtitleTextView = (TextView) listItemView.findViewById(R.id.subtitle_text_view);
        // Get the subtitle from the currentInfo object and set this text on
        // the Subtitle TextView.
        assert currentInfo != null;
        subtitleTextView.setText(currentInfo.getSubtitle());

        // Find the TextView in the info_list_item.xml layout with the ID title_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);

        // Get the title from the currentInfo object and set this text on
        // the title TextView.
        titleTextView.setText(currentInfo.getTitle());

        // Find the ImageView in the info_list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this info or not
        if (currentInfo.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentInfo.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Find the ImageView in the info_list_item.xml layout with the ID arrow.
        ImageView imageViewArrow = (ImageView) listItemView.findViewById(R.id.arrow);
        // Check if an image is provided for this info or not
        if (currentInfo.hasImageArrow()) {
            // If an image is available, display the provided image based on the resource ID
            imageViewArrow.setImageResource(currentInfo.getImageResourceIdArrow());
            // Make sure the view is visible
            imageViewArrow.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageViewArrow.setVisibility(View.GONE);
        }

        // Set the theme color for the info list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole info list item layout (containing 2 TextViews and 2 ImageViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}