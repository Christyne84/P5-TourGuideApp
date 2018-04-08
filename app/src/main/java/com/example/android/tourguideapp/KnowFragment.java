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
public class KnowFragment extends Fragment {

    public KnowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.image_banner);
        image.setImageResource(R.drawable.frankfurt);

        // Create a list of infos
        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info(getString(R.string.history_title), getString(R.string.history_subtitle)));
        infos.add(new Info(getString(R.string.area_title), getString(R.string.area_subtitle)));
        infos.add(new Info(getString(R.string.climate_title), getString(R.string.climate_subtitle)));
        infos.add(new Info(getString(R.string.demography_title),getString(R.string.demography_subtitle)));
        infos.add(new Info(getString(R.string.transport_title), getString(R.string.transport_subtitle)));
        infos.add(new Info(getString(R.string.economy_title), getString(R.string.economy_subtitle)));
        infos.add(new Info(getString(R.string.life_quality_title), getString(R.string.life_quality_subtitle)));
        infos.add(new Info(getString(R.string.healt_title), getString(R.string.health_subtitle)));
        infos.add(new Info(getString(R.string.education_title), getString(R.string.education_subtitle)));
        infos.add(new Info(getString(R.string.religion_title), getString(R.string.religion_subtitle)));
        infos.add(new Info(getString(R.string.traditions_title), getString(R.string.traditions_subtitle)));
        infos.add(new Info(getString(R.string.shopping_title), getString(R.string.shopping_subtitle)));
        infos.add(new Info(getString(R.string.emergency_title), getString(R.string.emergency_subtitle)));

        // Create an {@link InfoAdapter}, whose data source is a list of {@link Info}s. The
        // adapter knows how to create list items for each item in the list.
        InfoAdapter adapter = new InfoAdapter(getActivity(), infos, R.color.category_know);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // info_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link InfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Info} in the list.
        listView.setAdapter(adapter);
        listView.setBackgroundColor(getResources().getColor(R.color.category_know));

        return rootView;
    }

}
