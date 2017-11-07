package com.taesu.seoul2.MainActivity_detail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.taesu.seoul2.R;

import static com.taesu.seoul2.Place_detail.Tab1_rv_detail.image1;
import static com.taesu.seoul2.Place_detail.Tab1_rv_detail.image2;
import static com.taesu.seoul2.Place_detail.Tab1_rv_detail.image3;

/**
 * Created by park on 2017-10-29.
 */

public class ViewPagerAdapterMainNearPlace extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private String [] image = {
            image1,
            image2,
            image3};

    public ViewPagerAdapterMainNearPlace(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //String a = image1;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_place1_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewPlace1);

        Glide.with(context)
                .load(image[position])
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
