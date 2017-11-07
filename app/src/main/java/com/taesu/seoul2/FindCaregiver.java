package com.taesu.seoul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.taesu.seoul2.FindCaregiver_detail.FindCaregiverPost;
import com.taesu.seoul2.MySQL.SenderReceiverFindCaregiver;

public class FindCaregiver extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;

    RecyclerView rv;
    String urlAddress = "http://13.124.11.28/taesu/viewFindcaregiver.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcaregiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent post = new Intent(FindCaregiver.this, FindCaregiverPost.class);
                startActivity(post);

            }
        });

        drawer  = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rv = (RecyclerView) findViewById(R.id.rvFindcaregiver);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        SenderReceiverFindCaregiver srF = new SenderReceiverFindCaregiver(this, urlAddress, rv);
        srF.execute();
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
                Intent main = new Intent(FindCaregiver.this, MainActivity.class);
                startActivity(main);
                break;

            case R.id.nav_Place:
                Intent place = new Intent(FindCaregiver.this, Place.class);
                startActivity(place);
                break;

            case R.id.nav_Find_Caregiver:
                Intent FindCaregiver = new Intent(FindCaregiver.this, FindCaregiver.class);
                startActivity(FindCaregiver);
                break;

            case R.id.nav_Notify:
                Intent Notify = new Intent(FindCaregiver.this, Notify.class);
                startActivity(Notify);
                break;

            case R.id.nav_Find_Patient:
                Intent Find_Patient = new Intent(FindCaregiver.this, FindPatient.class);
                startActivity(Find_Patient);
                break;

            case R.id.nav_Manual:
                Intent Manual = new Intent(FindCaregiver.this, Manual.class);
                startActivity(Manual);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}