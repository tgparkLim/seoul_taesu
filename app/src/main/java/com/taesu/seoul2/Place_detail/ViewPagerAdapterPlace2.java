package com.taesu.seoul2.Place_detail;

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

import static com.taesu.seoul2.Place_detail.Tab2_rv_detail.image12;
import static com.taesu.seoul2.Place_detail.Tab2_rv_detail.image22;
import static com.taesu.seoul2.Place_detail.Tab2_rv_detail.image32;

/**
 * Created by park on 2017-10-31.
 */

public class ViewPagerAdapterPlace2 extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private String [] image = {
            image12,
            image22,
            image32};

    public ViewPagerAdapterPlace2(Context context) {
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
        View view = layoutInflater.inflate(R.layout.custom_place2_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewPlace2);

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