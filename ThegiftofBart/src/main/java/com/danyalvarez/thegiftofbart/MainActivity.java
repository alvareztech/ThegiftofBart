package com.danyalvarez.thegiftofbart;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    private Button mAButton;
    private Button mBButton;
    private Button mCButton;

    private ArrayList<Integer> mSoundList;

    private SoundPool mSoundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);

        mSoundList = new ArrayList<Integer>();
        mSoundList.add(mSoundPool.load(this, R.raw.shut_up, 1));
        mSoundList.add(mSoundPool.load(this, R.raw.kiss_my_ass, 1));
        mSoundList.add(mSoundPool.load(this, R.raw.go_the_hell, 1));
        mSoundList.add(mSoundPool.load(this, R.raw.callate, 1));
        mSoundList.add(mSoundPool.load(this, R.raw.idiota, 1));
        mSoundList.add(mSoundPool.load(this, R.raw.vete_al_diablo, 1));

        mAButton = (Button) findViewById(R.id.aButton);
        mBButton = (Button) findViewById(R.id.bButton);
        mCButton = (Button) findViewById(R.id.cButton);

        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(0);
            }
        });
        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(1);
            }
        });
        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(2);
            }
        });
    }

    public void playSound(int i) {
        String code = Locale.getDefault().getISO3Language();
        if (code.equals("spa")) {
            i += 3;
        }
        mSoundPool.play(mSoundList.get(i), 1, 1, 0, 0, 1);
    }

}
