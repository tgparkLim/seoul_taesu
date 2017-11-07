package com.taesu.seoul2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.taesu.seoul2.MainActivity_detail.MainNearPlaceGoogleMap;
import com.taesu.seoul2.MainActivity_detail.ViewPagerAdapter;
import com.taesu.seoul2.MySQL.SenderReceiverMainNearPlace;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static com.taesu.seoul2.Place.userID;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;

    //fetch image from server
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;

    DotsIndicator dotsIndicator;

    TextView testid;

    //main bookmark
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    //current location
    public static final int MY_PERMISSION_REQUEST_LOCATION = 1;
    public TextView current_txt;

    //rv main
    RecyclerView rvmain;
    ImageView noDataImg, noNetworkImg;
    String urlAddress = "http://13.124.11.28/taesu/viewmainnearplace.php";

    //test1031 google marker
    Button viewmoreplaceBtn;
    static String latSNow;
    static String lonSNow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        //startActivity(new Intent(this, Splash.class));
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //tab, navigationview
        drawer  = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);

        viewPager.setAdapter(viewPagerAdapter);

        dotsIndicator.setViewPager(viewPager);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        userID = getIntent().getStringExtra("userID");


        //rv main
        rvmain = (RecyclerView) findViewById(R.id.rvMain);

        noDataImg = (ImageView) findViewById(R.id.nodataImgMNP);
        noNetworkImg = (ImageView) findViewById(R.id.noserverMNP);


        //testid = (TextView) findViewById(R.id.idtest);
        //testid.setText(userID);

        //current location
        current_txt = (TextView) findViewById(R.id.currentlocation);

        if(ContextCompat.checkSelfPermission(MainActivity.this,
                ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    ACCESS_COARSE_LOCATION)) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
            }

        } else {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            try {

                current_txt.setText(findAddress(location.getLatitude(), location.getLongitude()));

                double lat = location.getLatitude();
                double lon = location.getLongitude();

                latSNow = Double.toString(lat);
                lonSNow = Double.toString(lon);

                SenderReceiverMainNearPlace srmnp
                        = new SenderReceiverMainNearPlace(MainActivity.this, latSNow, lonSNow, urlAddress, rvmain ,noDataImg, noNetworkImg);

                srmnp.execute();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
            }
        }
        //current_txt.setText("");

        current_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(MainActivity.this,
                        ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                            ACCESS_COARSE_LOCATION)) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
                    } else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[] {ACCESS_COARSE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
                    }

                } else {
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    try {

                        current_txt.setText(findAddress(location.getLatitude(), location.getLongitude()));

                        double lat = location.getLatitude();
                        double lon = location.getLongitude();

                        String latS = Double.toString(lat);
                        String lonS = Double.toString(lon);

                        SenderReceiverMainNearPlace srmnp
                                = new SenderReceiverMainNearPlace(MainActivity.this, latS, lonS, urlAddress, rvmain, noDataImg, noNetworkImg);

                        srmnp.execute();


                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        rvmain.setLayoutManager(new LinearLayoutManager(this));
        rvmain.setItemAnimator(new DefaultItemAnimator());

        viewmoreplaceBtn = (Button) findViewById(R.id.viewMorePlace);
        viewmoreplaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainNearPlaceGoogleMap.class);

                i.putExtra("gooLatitude", latSNow);
                i.putExtra("gooLongitude", lonSNow);

                startActivity(i);
            }
        });
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_main:
                Intent main = new Intent(MainActivity.this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.nav_Place:
                Intent place = new Intent(MainActivity.this, Place.class);
                startActivity(place);
                break;

            case R.id.nav_Find_Caregiver:
                Intent FindCaregiver = new Intent(MainActivity.this, FindCaregiver.class);
                startActivity(FindCaregiver);
                break;

            case R.id.nav_Notify:
                Intent Notify = new Intent(MainActivity.this, Notify.class);
                startActivity(Notify);
                break;

            case R.id.nav_share:
                shareKaKao();
                break;

            case R.id.nav_Find_Patient:
                Intent Find_Patient = new Intent(MainActivity.this, FindPatient.class);
                startActivity(Find_Patient);
                break;

            case R.id.nav_Manual:
                Intent Manual = new Intent(MainActivity.this, Manual.class);
                startActivity(Manual);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void shareKaKao() {

        try{
            final KakaoLink kakaoLink = KakaoLink.getKakaoLink(this);
            final KakaoTalkLinkMessageBuilder kakaoBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

            //메시지 추가
            kakaoBuilder.addText("실버케어 어플입니다.");

            //이미지
            String url = "https://www.google.co.kr/imgres?imgurl=http%3A%2F%2Fwww.easylaw.go.kr%2FCSP%2Ftemplate%2FBIN0002%5B1%5D.bmp&imgrefurl=https%3A%2F%2Fwww.easylaw.go.kr%2FCSP%2FCnpClsMain.laf%3FpopMenu%3Dov%26csmSeq%3D673%26ccfNo%3D1%26cciNo%3D1%26cnpClsNo%3D1&docid=ulopv6537O7QfM&tbnid=ELIsDtAR_RsQtM%3A&vet=10ahUKEwjzycfEl_LWAhWCspQKHe2kBL8QMwgkKAAwAA..i&w=496&h=321&bih=740&biw=767&q=%EB%85%B8%EC%9D%B8%EB%B3%B5%EC%A7%80&ved=0ahUKEwjzycfEl_LWAhWCspQKHe2kBL8QMwgkKAAwAA&iact=mrc&uact=8";
            kakaoBuilder.addImage(url, 160, 160);

            //앱 실행버튼 추가
            kakaoBuilder.addAppButton("앱 실행");

            //메시지 발송
            kakaoLink.sendMessage(kakaoBuilder, this);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_LOCATION: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(ContextCompat.checkSelfPermission(MainActivity.this,
                            ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        try {

                            current_txt.setText(findAddress(location.getLatitude(), location.getLongitude()));

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(this, "No permission granted!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //get location
    public String findAddress(double latitude, double longitude) {

        String currentLocation = "";

        //StringBuffer stringBuffer = new StringBuffer();
        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.KOREA);
        List<Address> addressList;

        try {

            addressList = geocoder.getFromLocation(latitude, longitude, 1);

            if(addressList.size() > 0) {

                currentLocation = addressList.get(0).getAddressLine(0).toString();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentLocation;

    }

}