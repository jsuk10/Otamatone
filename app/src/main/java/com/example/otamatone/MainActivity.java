package com.example.otamatone;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private SoundPool pool;
    private ImageView background;
    private ImageButton[] button = new ImageButton[10];
    private AdView mAdView;
    int arr[] = new int[10];
    int sound[] = new int[10];
    int touchCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win = getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);

        getSupportActionBar().hide();
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
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SetImage();
        addMusic();
    }
    @Override
    protected void onStop() {
        super.onStop();
        pool.release();
        pool = null;
    }

    public void SetImage(){
        for(int i = 0 ; i < 10 ; i++) {
            int resId = getResources().getIdentifier("button" + (i + 1), "id", getPackageName());
            button[i] = (ImageButton) findViewById(resId);
            button[i].setImageResource(R.drawable.defultbutton);
            button[i].setOnTouchListener(new View.OnTouchListener(){
                public boolean onTouch(View v, MotionEvent event) {
                    int id = v.getId();
                    int status = event.getAction();
                    if(status == MotionEvent.ACTION_UP) {
                        actionUpEvent(id);
                    }else if(status == MotionEvent.ACTION_DOWN) {
                        actionDownEvent(id);
                    }
                    return false;
                }
            });
        }
        background = findViewById(R.id.backGround);
        background.setImageResource(R.drawable.defultbackground);
    }

    public void actionUpEvent(int id){
        touchCount--;
        if(touchCount == 0)
            background.setImageResource(R.drawable.defultbackground);
        Log.e("tt",Integer.toString(id));
        switch (id) {
            case R.id.button10:
                button[9].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[0]);
                break;
            case R.id.button9:
                button[8].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[1]);
                break;
            case R.id.button8:
                button[7].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[2]);
                break;
            case R.id.button7:
                button[6].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[3]);
                break;
            case R.id.button6:
                button[5].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[4]);
                break;
            case R.id.button5:
                button[4].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[5]);
                break;
            case R.id.button4:
                button[3].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[6]);
                break;
            case R.id.button3:
                button[2].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[7]);
                break;
            case R.id.button2:
                button[1].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[8]);
                break;
            case R.id.button1:
                button[0].setImageResource(R.drawable.defultbutton);
                pool.stop(sound[9]);
                break;
        }
    }

    public void actionDownEvent(int id){
        touchCount++;
        background.setImageResource(R.drawable.onclickbackground);
        switch (id) {
            case R.id.button10:
                button[9].setImageResource(R.drawable.onclickbutton);
                sound[0] = pool.play(arr[0], 1, 1, 0, -1, 1);
                break;
            case R.id.button9:
                button[8].setImageResource(R.drawable.onclickbutton);
                sound[1] = pool.play(arr[1], 1, 1, 0, -1, 1);
                break;
            case R.id.button8:
                button[7].setImageResource(R.drawable.onclickbutton);
                sound[2] = pool.play(arr[2], 1, 1, 0, -1, 1);
                break;
            case R.id.button7:
                button[6].setImageResource(R.drawable.onclickbutton);
                sound[3] = pool.play(arr[3], 1, 1, 0, -1, 1);
                break;
            case R.id.button6:
                button[5].setImageResource(R.drawable.onclickbutton);
                sound[4] = pool.play(arr[4], 1, 1, 0, -1, 1);
                break;
            case R.id.button5:
                button[4].setImageResource(R.drawable.onclickbutton);
                sound[5] = pool.play(arr[5], 1, 1, 0, -1, 1);
                break;
            case R.id.button4:
                button[3].setImageResource(R.drawable.onclickbutton);
                sound[6] = pool.play(arr[6], 1, 1, 0, -1, 1);
                break;
            case R.id.button3:
                button[2].setImageResource(R.drawable.onclickbutton);
                sound[7] = pool.play(arr[7], 1, 1, 0, -1, 1);
                break;
            case R.id.button2:
                button[1].setImageResource(R.drawable.onclickbutton);
                sound[8] = pool.play(arr[8], 1, 1, 0, -1, 1);
                break;
            case R.id.button1:
                button[0].setImageResource(R.drawable.onclickbutton);
                sound[9] = pool.play(arr[9], 1, 1, 0, -1, 1);
                break;
        }
    }
    public void addMusic() {
        pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
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

}
