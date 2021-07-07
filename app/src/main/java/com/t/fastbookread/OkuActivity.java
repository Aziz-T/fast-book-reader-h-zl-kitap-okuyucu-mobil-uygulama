package com.t.fastbookread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class OkuActivity extends AppCompatActivity {

        private TextView icerik;
        String metin;
        String icerikDizi[] ;
        int dizi[] ;
        double time=0.0;
        int tur=0,ayar=500;
        Timer timer;
        TimerTask timerTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oku);
        icerik = findViewById(R.id.icerik);


        timer = new Timer();
        metin = getIntent().getStringExtra("icerik");
        dizi = new int[200];




        getKelimeler();

        setTimer(ayar);











    }

    private void setTimer(int ayar) {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        tur++;
                        int rounded = (int) Math.round(time);
                        if(tur<icerikDizi.length){
                            icerik.setText(icerikDizi[tur]);
                        }else {
                            icerik.setText(rounded+"");
                        }

                    }
                });

            }
        };

        timer.scheduleAtFixedRate(timerTask,0,ayar);

    }

    private void getKelimeler() {
        int sayi, beginIndex=0,endIndex;
        sayi = getBosluk(metin);
        icerikDizi = new String[sayi+1];
        for(int c = 0 ; c < sayi ; c++){
            endIndex = dizi[c];
            if(dizi[c] < metin.length())
            icerikDizi[c] = metin.substring(beginIndex,endIndex);
            beginIndex = endIndex;
        }
    }

    private int getBosluk(String metin) {
        int i =0 ,sayi=0;

        if(metin != null && !metin.equals("")){
            for(int l= 0 ; l < metin.length() ; l++){
                char ch = metin.charAt(l);
                if(ch == ' '){
                    dizi[i]= l ;
                    i++;
                    sayi++;
                }
            }
            return sayi;
        }else {
            Toast.makeText(this, "Metin null"+"", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}