package com.taesu.seoul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.taesu.seoul2.Manual_detail.manual0;
import com.taesu.seoul2.Manual_detail.manual1;
import com.taesu.seoul2.Manual_detail.manual2;
import com.taesu.seoul2.Manual_detail.manual3;
import com.taesu.seoul2.Manual_detail.manual4;
import com.taesu.seoul2.Manual_detail.manual5;
import com.taesu.seoul2.Manual_detail.manual6;
import com.taesu.seoul2.Manual_detail.manual7;

import java.util.ArrayList;

import static com.taesu.seoul2.R.menu.manual;

public class Manual extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final int FRAGMENT0 = 0;
    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;
    private final int FRAGMENT5 = 5;
    private final int FRAGMENT6 = 6;
    private final int FRAGMENT7 = 7;

    private ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //spinner
        arrayList = new ArrayList();
        arrayList.add("노인 종합 복지관");
        arrayList.add("노인주거복지시설");
        arrayList.add("노인의료복지시설");
        arrayList.add("데이케어센터");
        arrayList.add("재가노인복지시설");
        arrayList.add("노인교실.노인대학");
        arrayList.add("경로당");
        arrayList.add("노인보호전문기관");

        final String[] select_item = {""};

        Spinner spinner = (Spinner) findViewById(R.id.sp_manual);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, arrayList);

        spinner.setAdapter(adapter);

        //Button button = (Button) findViewById(R.id.sp_button);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select_item[0] = String.valueOf(arrayList.get(position));

                switch (position) {
                    case 0:
                        callFragment(FRAGMENT0);
                        break;

                    case 1:
                        callFragment(FRAGMENT1);
                        break;

                    case 2:
                        callFragment(FRAGMENT2);
                        break;

                    case 3:
                        callFragment(FRAGMENT3);
                        break;

                    case 4:
                        callFragment(FRAGMENT4);
                        break;

                    case 5:
                        callFragment(FRAGMENT5);
                        break;

                    case 6:
                        callFragment(FRAGMENT6);
                        break;

                    case 7:
                        callFragment(FRAGMENT7);
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //fragment
    private void callFragment(int fragment_no) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment_no) {
            case 0:
                manual0 manual0 = new manual0();
                transaction.replace(R.id.fragment_container_manual, manual0);
                transaction.commit();
                break;

            case 1:
                manual1 manual1 = new manual1();
                transaction.replace(R.id.fragment_container_manual, manual1);
                transaction.commit();
                break;

            case 2:
                manual2 manual2 = new manual2();
                transaction.replace(R.id.fragment_container_manual, manual2);
                transaction.commit();
                break;

            case 3:
                manual3 manual3 = new manual3();
                transaction.replace(R.id.fragment_container_manual, manual3);
                transaction.commit();
                break;

            case 4:
                manual4 manual4 = new manual4();
                transaction.replace(R.id.fragment_container_manual, manual4);
                transaction.commit();
                break;

            case 5:
                manual5 manual5 = new manual5();
                transaction.replace(R.id.fragment_container_manual, manual5);
                transaction.commit();
                break;

            case 6:
                manual6 manual6 = new manual6();
                transaction.replace(R.id.fragment_container_manual, manual6);
                transaction.commit();
                break;

            case 7:
                manual7 manual7 = new manual7();
                transaction.replace(R.id.fragment_container_manual, manual7);
                transaction.commit();
                break;

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
        getMenuInflater().inflate(manual, menu);
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
                Intent main = new Intent(Manual.this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.nav_Place:
                Intent place = new Intent(Manual.this, Place.class);
                startActivity(place);
                break;

            case R.id.nav_Find_Caregiver:
                Intent FindCaregiver = new Intent(Manual.this, FindCaregiver.class);
                startActivity(FindCaregiver);
                break;

            case R.id.nav_Notify:
                Intent Notify = new Intent(Manual.this, Notify.class);
                startActivity(Notify);
                break;

            case R.id.nav_share:
                shareKaKao();
                break;

            case R.id.nav_Find_Patient:
                Intent Find_Patient = new Intent(Manual.this, FindPatient.class);
                startActivity(Find_Patient);
                break;

            case R.id.nav_Manual:
                Intent Manual = new Intent(Manual.this, Manual.class);
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
}
