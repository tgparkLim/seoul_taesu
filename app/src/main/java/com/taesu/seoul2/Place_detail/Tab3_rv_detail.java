package com.taesu.seoul2.Place_detail;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.barcode.Barcode;
import com.taesu.seoul2.R;

import java.io.IOException;
import java.util.List;

/**
 * Created by park on 2017-10-19.
 */

public class Tab3_rv_detail extends AppCompatActivity implements OnMapReadyCallback {

    private TextView nameTxt3,categoryTxt3,phoneTxt3,addressTxt3,linkTxt3,sizeTxt3,peopleTxt3;
    ImageView placeimage1_1,placeimage1_2, placeimage1_3;

    public static String image31, image32, image33;

    //fetch image from server
    ViewPager viewPager;

    ViewPagerAdapterPlace3 viewPagerAdapterPlace3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3_rv_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.place_detail_toolBar);

        //map
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.fragment_place_map3);
        mapFragment.getMapAsync(this);

        nameTxt3 = (TextView) findViewById(R.id.txt_tab3placename);
        categoryTxt3 = (TextView) findViewById(R.id.txt_tab3placecategory);
        phoneTxt3 = (TextView) findViewById(R.id.txt_placephone3);
        addressTxt3 = (TextView) findViewById(R.id.txt_placeadd3);
        linkTxt3 =(TextView) findViewById(R.id.txt_placelink3);
        sizeTxt3 = (TextView) findViewById(R.id.txt_placesize3);
        peopleTxt3 = (TextView) findViewById(R.id.txt_placepeople3);
//        placeimage1_1 = (ImageView) findViewById(R.id.img_placeview1_1);
//        placeimage1_2 = (ImageView) findViewById(R.id.img_placeview1_2);
//        placeimage1_3 = (ImageView) findViewById(R.id.img_placeview1_3);

        //RECEIVE
        Intent i = this.getIntent();
        String name3 = i.getExtras().getString("NAME_KEY");
        String phone3 = i.getExtras().getString("PHONE_KEY");
        String address3 = i.getExtras().getString("ADDRESS_KEY");
        String link3 = i.getExtras().getString("LINK_KEY");
        String size3 = i.getExtras().getString("SIZE_KEY");
        String people3 = i.getExtras().getString("PEOPLE_KEY");
        String category3 = i.getExtras().getString("CATEGORY_KEY");

        image31 = i.getExtras().getString("IMAGE1_KEY");
        image32 = i.getExtras().getString("IMAGE2_KEY");
        image33 = i.getExtras().getString("IMAGE3_KEY");
        //BIND
        nameTxt3.setText(name3);
        phoneTxt3.setText(Html.fromHtml("<u>"+phone3+"</u>"));
        addressTxt3.setText(address3);
        linkTxt3.setText(link3);
        sizeTxt3.setText(size3);
        peopleTxt3.setText(people3);
        categoryTxt3.setText(category3);

        viewPagerAdapterPlace3 = new ViewPagerAdapterPlace3(this);
        viewPager = (ViewPager) findViewById(R.id.viewPagerPlace3);
        viewPager.setAdapter(viewPagerAdapterPlace3);


//        Glide.with(context)
//                .load(image1)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(placeimage1_1);
        //전화걸기
        phoneTxt3.setOnClickListener(mClickListener);
//        SpannableString content = new SpannableString();
//        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
//        phoneTxt1.setText(content);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneTxt3.getText().toString()));
            startActivity(intent);
        }
    };

    @Override
    public void onMapReady(final GoogleMap map) {

//        TextView txtlatlng = (TextView) findViewById(R.id.txt_latlng);
        Geocoder geocoder = new Geocoder(this);

        Address addr;
        Barcode.GeoPoint location = null;

        //List<android.location.Address> list = null;
        String str = addressTxt3.getText().toString();

        double lat = 0;
        double lng = 0;
        try {
            List<Address> listAddress = geocoder.getFromLocationName(str, 1);
            if (listAddress.size() > 0) {
                addr = listAddress.get(0);
                //double lat = (double) (addr.getLatitude() * 1E6);
                lat = (double) addr.getLatitude();
                lng = (double) addr.getLongitude();
                //location = new Barcode.GeoPoint(dd,dd);

//                txtlatlng.setText(lat + ", " + lng);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            list = geocoder.getFromLocationName(str, 10);
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("test", "입출력 오류");
//        }
//        double lat = 0;
//        double lon = 0;
//        if (list != null) {
//            if (list.size() == 0) {
//                txtlatlng.setText("해당주소없음");
//            } else {
//
//                android.location.Address addr = list.get(0);
//                lat = addr.getLatitude();
//                lon = addr.getLongitude();
//
//                String latt = Double.toString(lat);
//                String lonn = Double.toString(lon);
//
//                txtlatlng.setText(latt + ", " + lonn);
//            }
//        }

        LatLng SEOUL = new LatLng(lat, lng);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
}
