package com.taesu.seoul2.MainActivity_detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.taesu.seoul2.Place_detail.Tab1Fragment;


/**
 * Created by park on 2017-10-18.
 */

public class PagerMainBookmark extends FragmentStatePagerAdapter {

    int tabCountBookmark;

    public PagerMainBookmark(FragmentManager fm, int tabCountBookmark) {

        super(fm);
        this.tabCountBookmark = tabCountBookmark;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                TabMain1Fragment tabMain1Fragment = new TabMain1Fragment();
                return tabMain1Fragment;

            case 1:
                TabMain2Fragment tabMainBookmark2 = new TabMain2Fragment();
                return tabMainBookmark2;

            default: return null;

        }
    }

    @Override
    public int getCount() {

        return tabCountBookmark;

    }
}
