package com.example.lesson18soundpage10;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
    private Context pContext;
    private SoundPool sndPool;
    private float rate = 1.0f;
    private float masterVolume = 1.0f;
    private float leftVolume = 1.0f;
    private float rightVolume = 1.0f;
    private float balance = 0.5f;

    public SoundManager(Context appContext) {
        sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 0);
        pContext = appContext;
    }
    public int load(int sound_id) {
        return sndPool.load(pContext, sound_id, 1);
    }
    public void play(int sound_id) {
        sndPool.play(sound_id, leftVolume, rightVolume, 1, 0, rate);
    }
    public void setVolume(float vol) {
        masterVolume = vol;
        if (balance < 1.0f) {
            leftVolume = masterVolume;
            rightVolume = masterVolume * balance;
        } else {
            rightVolume = masterVolume;
            leftVolume = masterVolume * (2.0f - balance);
        }
    }
    public void setSpeed(float speed){
        rate = speed;
        if (rate < 0.01f) rate = 0.01f;
        if (rate > 2.0f) rate = 2.0f;
    }
    public void setBalance(float balVal){
        balance = balVal;
        setVolume(masterVolume);
    }
    public void unloadAll(){
        sndPool.release();
    }
}
