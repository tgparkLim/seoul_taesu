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

import static com.taesu.seoul2.R.id.viewPager;

/**
 * Created by park on 2017-10-18.
 */

public class Tab2_rv_detail extends AppCompatActivity implements OnMapReadyCallback {

    private TextView nameTxt2,categoryTxt2,phoneTxt2,addressTxt2,linkTxt2,sizeTxt2,peopleTxt2;
    ImageView placeimage1_1,placeimage1_2, placeimage1_3;

    public static String image21, image22, image23;

    //fetch image from server
    ViewPager viewPager;

    ViewPagerAdapterPlace2 viewPagerAdapterPlace2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2_rv_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.place_detail_toolBar);

        //map
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.fragment_place_map2);
        mapFragment.getMapAsync(this);

        nameTxt2 = (TextView) findViewById(R.id.txt_tab2placename);
        categoryTxt2 = (TextView) findViewById(R.id.txt_tab2placecategory);
        phoneTxt2 = (TextView) findViewById(R.id.txt_placephone2);
        addressTxt2 = (TextView) findViewById(R.id.txt_placeadd2);
        linkTxt2 =(TextView) findViewById(R.id.txt_placelink2);
        sizeTxt2 = (TextView) findViewById(R.id.txt_placesize2);
        peopleTxt2 = (TextView) findViewById(R.id.txt_placepeople2);
//        placeimage1_1 = (ImageView) findViewById(R.id.img_placeview1_1);
//        placeimage1_2 = (ImageView) findViewById(R.id.img_placeview1_2);
//        placeimage1_3 = (ImageView) findViewById(R.id.img_placeview1_3);

        //RECEIVE
        Intent i = this.getIntent();
        String name2 = i.getExtras().getString("NAME_KEY");
        String phone2 = i.getExtras().getString("PHONE_KEY");
        String address2 = i.getExtras().getString("ADDRESS_KEY");
        String link2 = i.getExtras().getString("LINK_KEY");
        String size2 = i.getExtras().getString("SIZE_KEY");
        String people2 = i.getExtras().getString("PEOPLE_KEY");
        String category2 = i.getExtras().getString("CATEGORY_KEY");

        image21 = i.getExtras().getString("IMAGE1_KEY");
        image22 = i.getExtras().getString("IMAGE2_KEY");
        image23 = i.getExtras().getString("IMAGE3_KEY");
        //BIND
        nameTxt2.setText(name2);
        phoneTxt2.setText(Html.fromHtml("<u>"+phone2+"</u>"));
        addressTxt2.setText(address2);
        linkTxt2.setText(link2);
        sizeTxt2.setText(size2);
        peopleTxt2.setText(people2);
        categoryTxt2.setText(category2);

        viewPagerAdapterPlace2 = new ViewPagerAdapterPlace2(this);
        viewPager = (ViewPager) findViewById(R.id.viewPagerPlace2);
        viewPager.setAdapter(viewPagerAdapterPlace2);


        //전화걸기
        phoneTxt2.setOnClickListener(mClickListener);
//        SpannableString content = new SpannableString();
//        content.setSpan(new UnderlineSpan(), 0, content.length(),0);
//        phoneTxt1.setText(content);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneTxt2.getText().toString()));
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
        String str = addressTxt2.getText().toString();

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
//
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
