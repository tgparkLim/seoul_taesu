package com.taesu.seoul2.MainActivity_detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.taesu.seoul2.R;

import java.util.ArrayList;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static com.taesu.seoul2.MainActivity.MY_PERMISSION_REQUEST_LOCATION;
import static com.taesu.seoul2.Recycler.MyAdapterMainNearPlace.mainNearPlace_modelArrayList;

public class MainNearPlaceGoogleMap extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    TextView name, lat, lon;

    Marker selectedMarker;
    View marker_root_view;
    TextView tv_marker;
    private GoogleMap mMap;

    //
    Double la = null;
    Double ln = null;

    int i_MNP = 0;

    int temp_index;

    MarkerItem makerNumber;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_near_place_google_map);

        name = (TextView) findViewById(R.id.nameGoogle);
        lat = (TextView) findViewById(R.id.latitudeGoogle);
        lon = (TextView) findViewById(R.id.longitudeGoogle);

        mainNearPlace_modelArrayList.get(0).getNameMNP();
        mainNearPlace_modelArrayList.get(1).getNameMNP();

        //name.setText(mainNearPlace_modelArrayList.get(0).getNameMNP());
        //lat.setText(mainNearPlace_modelArrayList.get(1).getNameMNP());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_MNP);
        mapFragment.getMapAsync(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        temp_index = 0;

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MainNearPlaceGoogleMap.this,
                            ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        try {

                            //current_txt.setText(findAddress(location.getLatitude(), location.getLongitude()));
                            la = location.getLatitude();
                            ln = location.getLongitude();

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainNearPlaceGoogleMap.this, "Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(this, "No permission granted!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent nowi = getIntent();

        String ila = nowi.getExtras().getString("gooLatitude");
        String ilo = nowi.getExtras().getString("gooLongitude");

        la = Double.parseDouble(ila);
        ln = Double.parseDouble(ilo);

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.537523, 126.96558), 14));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(la, ln), 14));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);

        setCustomMarkerView();
        getSampleMarkerItems();




    }

    private void setCustomMarkerView() {

        marker_root_view = LayoutInflater.from(this).inflate(R.layout.marker_layout, null);
        tv_marker = (TextView) marker_root_view.findViewById(R.id.tv_marker);
    }


    private void getSampleMarkerItems() {
        final ArrayList<MarkerItem> sampleList = new ArrayList();

//        mainNearPlace_modelArrayList.get(0).getLatitudeMNP();
//        mainNearPlace_modelArrayList.get(1).getLatitudeMNP();
//        mainNearPlace_modelArrayList.get(2).getLatitudeMNP();
//        mainNearPlace_modelArrayList.get(3).getLatitudeMNP();
//
//        mainNearPlace_modelArrayList.get(0).getLongitudeMNP();
//        mainNearPlace_modelArrayList.get(1).getLongitudeMNP();
//        mainNearPlace_modelArrayList.get(2).getLongitudeMNP();
//        mainNearPlace_modelArrayList.get(3).getLongitudeMNP();
//
//        Double la0 = Double.parseDouble(mainNearPlace_modelArrayList.get(0).getLatitudeMNP());
//        Double la1 = Double.parseDouble(mainNearPlace_modelArrayList.get(1).getLatitudeMNP());
//        Double la2 = Double.parseDouble(mainNearPlace_modelArrayList.get(2).getLatitudeMNP());
//        Double la3 = Double.parseDouble(mainNearPlace_modelArrayList.get(3).getLatitudeMNP());
//
//        Double lo0 = Double.parseDouble(mainNearPlace_modelArrayList.get(0).getLongitudeMNP());
//        Double lo1 = Double.parseDouble(mainNearPlace_modelArrayList.get(1).getLongitudeMNP());
//        Double lo2 = Double.parseDouble(mainNearPlace_modelArrayList.get(2).getLongitudeMNP());
//        Double lo3 = Double.parseDouble(mainNearPlace_modelArrayList.get(3).getLongitudeMNP());
//
//        sampleList.add(new MarkerItem(la0, lo0, mainNearPlace_modelArrayList.get(0).getNameMNP()));
//        sampleList.add(new MarkerItem(la1, lo1, mainNearPlace_modelArrayList.get(1).getNameMNP()));
//        sampleList.add(new MarkerItem(la2, lo2, mainNearPlace_modelArrayList.get(2).getNameMNP()));
//        sampleList.add(new MarkerItem(la3, lo3, mainNearPlace_modelArrayList.get(3).getNameMNP()));
        for (i_MNP = 0; i_MNP < mainNearPlace_modelArrayList.size(); i_MNP++) {
            mainNearPlace_modelArrayList.get(i_MNP).getLatitudeMNP();
            mainNearPlace_modelArrayList.get(i_MNP).getLongitudeMNP();

            String LanTemp = mainNearPlace_modelArrayList.get(i_MNP).getLatitudeMNP();
            String LonTemp = mainNearPlace_modelArrayList.get(i_MNP).getLongitudeMNP();

            Double tempLan = Double.parseDouble(LanTemp);
            Double tempLon = Double.parseDouble(LonTemp);

            mainNearPlace_modelArrayList.get(i_MNP).getNameMNP();

            sampleList.add(new MarkerItem(i_MNP, tempLan, tempLon, mainNearPlace_modelArrayList.get(i_MNP).getNameMNP()));

        }

        for (MarkerItem markerItem : sampleList) {
            addMarker(markerItem, false);
        }

    }

    private Marker addMarker(MarkerItem markerItem, boolean isSelectedMarker) {


        LatLng position = new LatLng(markerItem.getLat(), markerItem.getLon());
        String name = markerItem.getName();

        //int id_temp = markerItem.getId();

        //String formatted2 = StringF
        //String formatted = NumberFormat.getCurrencyInstance().format((price));

        tv_marker.setText(name);
        //tv_marker.setText(formatted);

        if (isSelectedMarker) {
            tv_marker.setBackgroundResource(R.drawable.ic_marker_phone_blue);
            tv_marker.setTextColor(Color.WHITE);
        } else {
            tv_marker.setBackgroundResource(R.drawable.ic_marker_phone);
            tv_marker.setTextColor(Color.BLACK);
        }

        MarkerOptions markerOptions = new MarkerOptions();
        //markerOptions.title(Integer.toString(price));
        markerOptions.title(name);
        markerOptions.position(position);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker_root_view)));


        return mMap.addMarker(markerOptions);

    }

    // View를 Bitmap으로 변환
    private Bitmap createDrawableFromView(Context context, View view) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }

    private Marker addMarker(Marker marker, boolean isSelectedMarker) {


        double lat = marker.getPosition().latitude;
        double lon = marker.getPosition().longitude;
        String name = marker.getTitle();

        //MarkerItem temp = new MarkerItem(marker_index ,lat, lon, name);
        //MarkerItem temp = new MarkerItem(temp_index ,lat, lon, name);
        MarkerItem temp = new MarkerItem(lat, lon, name);
        //temp_index++;
        return addMarker(temp, isSelectedMarker);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        //makerNumber.getId();

        //marker.getSnippet();


        CameraUpdate center = CameraUpdateFactory.newLatLng(marker.getPosition());
        mMap.animateCamera(center);

        changeSelectedMarker(marker);

//        MainNearPlace_model mainNearPlaceModel
//                = mainNearPlace_modelArrayList.get(makerNumber.getId());
//
//        MyAdapterMainNearPlace myAdapterMainNearPlace = new MyAdapterMainNearPlace(MainNearPlaceGoogleMap.this, mainNearPlace_modelArrayList);
//        myAdapterMainNearPlace.openDetailActivity_MNP(
//                (mainNearPlaceModel.getNameMNP())
//                , mainNearPlaceModel.getCategoryMNP()
//                , mainNearPlaceModel.getPhoneMNP()
//                , mainNearPlaceModel.getAddressMNP()
//                , mainNearPlaceModel.getLinkMNP()
//                , mainNearPlaceModel.getSizeMNP()
//                , mainNearPlaceModel.getPeopleMNP()
//                , mainNearPlaceModel.getPlaceimage1MNP()
//                , mainNearPlaceModel.getPlaceimage2MNP()
//                , mainNearPlaceModel.getPlaceimage3MNP());

        return true;
    }

    private void changeSelectedMarker(Marker marker) {
        // 선택했던 마커 되돌리기
        if (selectedMarker != null) {
            addMarker(selectedMarker, false);
            selectedMarker.remove();
        }

        // 선택한 마커 표시
        if (marker != null) {
            selectedMarker = addMarker(marker, true);
            marker.remove();
        }


    }

    @Override
    public void onMapClick(LatLng latLng) {
        changeSelectedMarker(null);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MainNearPlaceGoogleMap Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
