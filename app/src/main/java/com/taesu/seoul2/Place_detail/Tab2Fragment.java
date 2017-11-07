package com.taesu.seoul2.Place_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.taesu.seoul2.MySQL.SenderReceiverPlace;
import com.taesu.seoul2.MySQL.SenderReceiverPlace2;
import com.taesu.seoul2.R;

/**
 * Created by park on 2017-09-08.
 */

public class Tab2Fragment extends Fragment {

    Button detailBtn;

    RecyclerView rv;
    ImageView noDataImg, noNetworkImg;
    String urlAddress = "http://13.124.11.28/taesu/searcher_place2.php";

    TextView textView;

    SearchView sv;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab2, container, false);



        //detailBtn = (Button) view.findViewById(R.id.Place1Detail);

        rv = (RecyclerView) view.findViewById(R.id.rvPlace2);
//        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setItemAnimator(new DefaultItemAnimator());

        noDataImg = (ImageView) view.findViewById(R.id.nodataImg);
        noNetworkImg = (ImageView) view.findViewById(R.id.noserver);

        //textView = (TextView) view.findViewById(R.id.test1);

        String blank ="";

        SenderReceiverPlace2 srp = new SenderReceiverPlace2(getContext(), blank, urlAddress, rv, noDataImg, noNetworkImg);
        srp.execute();

        sv = (SearchView) view.findViewById(R.id.sv2);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                SenderReceiverPlace2 sr = new SenderReceiverPlace2(getContext(), query, urlAddress, rv, noDataImg, noNetworkImg);
                sr.execute();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                SenderReceiverPlace2 sr = new SenderReceiverPlace2(getContext(), query, urlAddress, rv, noDataImg, noNetworkImg);
                sr.execute();

                return false;
            }
        });

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setItemAnimator(new DefaultItemAnimator());


        return view;

    }

}
