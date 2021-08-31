package com.example.setaudiability;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button mode,ring,vibrate,silent;
    private AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // without this silent option will not work
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!notificationManager.isNotificationPolicyAccessGranted())
            {
                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);
            }
        }

        vibrate=(Button)findViewById(R.id.button3);
        ring=(Button)findViewById(R.id.button2);

        mode=(Button)findViewById(R.id.button);
        silent=(Button)findViewById(R.id.button4);
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this,"Now in silent Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mod=myAudioManager.getRingerMode();
                if(mod==AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                } else if(mod==AudioManager.RINGER_MODE_NORMAL){
                    Toast.makeText(MainActivity.this,"Now in Ringing Mode",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Now in Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}