package com.example.otamatone;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private SoundPool pool;
    private AdView mAdView;
    int arr[] = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win = getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                // 광고가 문제 없이 로드시 출력됩니다.
                Log.d("@@@", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                // 광고 로드에 문제가 있을시 출력됩니다.
                Log.d("@@@", "onAdFailedToLoad " + errorCode);
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //        if (BuildConfig.DEBUG)
//            mAdView.setAdUnitId("@string/banner_ad_unit_id_for_test");
//        else
//            mAdView.setAdUnitId("@string/admob_app_id");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        addMusic();
    }

    public void addMusic() {
        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        arr[0] = pool.load(this, R.raw.a, 1);
        arr[1] = pool.load(this, R.raw.b, 1);
        arr[2] = pool.load(this, R.raw.c, 1);
        arr[3] = pool.load(this, R.raw.d, 1);
        arr[4] = pool.load(this, R.raw.e, 1);
        arr[5] = pool.load(this, R.raw.f, 1);
        arr[6] = pool.load(this, R.raw.g, 1);
        arr[7] = pool.load(this, R.raw.h, 1);
        arr[8] = pool.load(this, R.raw.i, 1);
        arr[9] = pool.load(this, R.raw.j, 1);
    }

    public void mOnClick(View v) {

        switch (v.getId()) {
            case R.id.button10:
                pool.play(arr[0], 1, 1, 0, 0, 1);
                break;
            case R.id.button9:
                pool.play(arr[1], 1, 1, 0, 0, 1);
                break;
            case R.id.button8:
                pool.play(arr[2], 1, 1, 0, 0, 1);
                break;
            case R.id.button7:
                pool.play(arr[3], 1, 1, 0, 0, 1);
                break;
            case R.id.button6:
                pool.play(arr[4], 1, 1, 0, 0, 1);
                break;
            case R.id.button5:
                pool.play(arr[5], 1, 1, 0, 0, 1);
                break;
            case R.id.button4:
                pool.play(arr[6], 1, 1, 0, 0, 1);
                break;
            case R.id.button3:
                pool.play(arr[7], 1, 1, 0, 0, 1);
                break;
            case R.id.button2:
                pool.play(arr[8], 1, 1, 0, 0, 1);
                break;
            case R.id.button1:
                pool.play(arr[9], 1, 1, 0, 0, 1);
                break;
        }
    }
}
