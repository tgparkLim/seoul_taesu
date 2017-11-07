//package com.taesu.seoul2;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class StartActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_start);
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Intent intent = new Intent(StartActivity.this, MainActivity.class);
//                startActivity(intent);
//
////                MainActivity mainActivity = new MainActivity();
////                mainActivity.sendRequest();
//
//                finish();
//            }
//        }, 2000);
//
//    }
//}
