package com.example.rm31374.broadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rm31374.broadcastreceiver.broadcast.AlarmeReceiver;

public class AlarmeActivity extends AppCompatActivity {
    private EditText etSegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarme);

        etSegundos = (EditText) findViewById(R.id.etSegundos);

    }

    public void configurar(View v) {
        String tempo = etSegundos.getText().toString();
        int t = Integer.parseInt(tempo);

        if (!tempo.equals("")) {

            Intent i =  new Intent(this, AlarmeReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(
                    this.getApplicationContext(),
                    1234, i, 0);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (t * 1000), pi);

            Toast.makeText(this, "Configurado para daqui " + t + " segundos",
                    Toast.LENGTH_LONG).show();

        }

    }
}
