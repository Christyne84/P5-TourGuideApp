package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeeFragment extends Fragment {

    public SeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.image_banner);
        image.setImageResource(R.drawable.attractions);

        // Create a list of infos
        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.see_info_list_item_title1), getString(R.string.art_museums_subtitle), R.drawable.stadel, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title2), getString(R.string.theaters_subtitle), R.drawable.english_theatre, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title3), getString(R.string.walks_subtitle), R.drawable.museumsufer, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title4), getString(R.string.gardens_subtitle), R.drawable.palmengarten, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title5), getString(R.string.specialty_museums_subtitle), R.drawable.dialog_museum, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title6), getString(R.string.flea_markets_subtitle), R.drawable.kleinmarkthalle, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title7), getString(R.string.specialty_museums_subtitle), R.drawable.klassikstadt, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title8), getString(R.string.history_museums_subtitle), R.drawable.senckenberg, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title9), getString(R.string.specialty_museums_subtitle), R.drawable.filmmuseum, R.drawable.arrow_right));
        infos.add(new Info(getString(R.string.see_info_list_item_title10), getString(R.string.exhibitions_fairs_subtitle), R.drawable.messe, R.drawable.arrow_right));

        // Create an {@link InfoAdapter}, whose data source is a list of {@link Info}s. The
        // adapter knows how to create list items for each item in the list.
        InfoAdapter adapter = new InfoAdapter(getActivity(), infos, R.color.category_see);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // info_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link InfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Info} in the list.
        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.category_see));

        return rootView;
    }
}
