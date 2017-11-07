package com.taesu.seoul2.MainActivity_detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taesu.seoul2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabMain1Fragment extends Fragment {

    RecyclerView rv;

    public TabMain1Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_main1, container, false);

        rv = (RecyclerView) view.findViewById(R.id.rvMainBookmark1);

        return view;
    }

}
