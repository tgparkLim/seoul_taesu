package com.taesu.seoul2.MainActivity_detail;

import android.app.FragmentManager;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.vision.barcode.Barcode;
import com.taesu.seoul2.Place_detail.ViewPagerAdapterPlace1;
import com.taesu.seoul2.R;

import java.io.IOException;
import java.util.List;

/**
 * Created by park on 2017-10-29.
 */

public class MainNearPlace_rv_detail extends AppCompatActivity implements OnMapReadyCallback {

    private TextView nameTxtMNP,categoryTxtMNP,phoneTxtMNP,addressTxtMNP,linkTxtMNP,sizeTxtMNP,peopleTxtMNP;
    ImageView placeimage1_1,placeimage1_2, placeimage1_3;

    public static String image1, image2, image3;

    //fetch image from server
    ViewPager viewPagerMNP;

    ViewPagerAdapterMainNearPlace viewPagerAdapterMainNearPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_near_place_rv_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.place_detail_toolBar);

        //map
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.fragment_place_map_mnp);
        mapFragment.getMapAsync(this);

        nameTxtMNP = (TextView) findViewById(R.id.txt_tab_mnp_placename);
        categoryTxtMNP = (TextView) findViewById(R.id.txt_tab_mnp_placecategory);
        phoneTxtMNP = (TextView) findViewById(R.id.txt_placephone_mnp);
        addressTxtMNP = (TextView) findViewById(R.id.txt_placeadd_mnp);
        linkTxtMNP =(TextView) findViewById(R.id.txt_placelink_mnp);
        sizeTxtMNP = (TextView) findViewById(R.id.txt_placesize_mnp);
        peopleTxtMNP = (TextView) findViewById(R.id.txt_placepeople_mnp);
//        placeimage1_1 = (ImageView) findViewById(R.id.img_placeview1_1);
//        placeimage1_2 = (ImageView) findViewById(R.id.img_placeview1_2);
//        placeimage1_3 = (ImageView) findViewById(R.id.img_placeview1_3);

        //RECEIVE
        Intent i = this.getIntent();
        String name1 = i.getExtras().getString("NAME_KEY");
        String phone1 = i.getExtras().getString("PHONE_KEY");
        String address1 = i.getExtras().getString("ADDRESS_KEY");
        String link1 = i.getExtras().getString("LINK_KEY");
        String size1 = i.getExtras().getString("SIZE_KEY");
        String people1 = i.getExtras().getString("PEOPLE_KEY");
        String category1 = i.getExtras().getString("CATEGORY_KEY");

        image1 = i.getExtras().getString("IMAGE1_KEY");
        image2 = i.getExtras().getString("IMAGE2_KEY");
        image3 = i.getExtras().getString("IMAGE3_KEY");

        //BIND
        nameTxtMNP.setText(name1);
        phoneTxtMNP.setText(phone1);
        addressTxtMNP.setText(address1);
        linkTxtMNP.setText(link1);
        sizeTxtMNP.setText(size1);
        peopleTxtMNP.setText(people1);
        categoryTxtMNP.setText(category1);

        viewPagerAdapterMainNearPlace = new ViewPagerAdapterMainNearPlace(this);
        viewPagerMNP = (ViewPager) findViewById(R.id.viewPagerPlace_mnp);
        viewPagerMNP.setAdapter(viewPagerAdapterMainNearPlace);

    }


    @Override
    public void onMapReady(final GoogleMap map) {

        TextView txtlatlng = (TextView) findViewById(R.id.txt_latlng_mnp);
        Geocoder geocoder = new Geocoder(this);

        Address addr;
        Barcode.GeoPoint location = null;

        //List<android.location.Address> list = null;
        String str = addressTxtMNP.getText().toString();

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

                txtlatlng.setText(lat + ", " + lng);


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