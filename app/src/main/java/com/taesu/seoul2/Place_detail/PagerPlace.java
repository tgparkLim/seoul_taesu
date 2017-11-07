package com.taesu.seoul2.Place_detail;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by park on 2017-09-08.
 */

public class PagerPlace extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerPlace(FragmentManager fm, int tabCount) {

        super(fm);
        this.tabCount = tabCount;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                return  tab1Fragment;

            case 1:
                Tab2Fragment tab2Fragment = new Tab2Fragment();
                return  tab2Fragment;

            case 2:
                Tab3Fragment tab3Fragment = new Tab3Fragment();
                return  tab3Fragment;

            default: return null;

        }
    }

    @Override
    public int getCount() {

        return tabCount;

    }

}
