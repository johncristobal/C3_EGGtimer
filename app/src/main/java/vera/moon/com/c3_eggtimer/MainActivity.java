package vera.moon.com.c3_eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public SeekBar barra;
    public TextView contador;
    public MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = (SeekBar)findViewById(R.id.seekBar);
        barra.setMax(600);
        barra.setProgress(30);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        contador = (TextView)findViewById(R.id.textView);

        media = MediaPlayer.create(this,R.raw.elli);
    }

    public void controlTimer(View v){

        new CountDownTimer(barra.getProgress()*1000+100,1000){

            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);
            }

            @Override
            public void onFinish() {

                contador.setText("0:00");

            }
        }.start();

    }

    public void updateTimer(int secondsleft){
        int minutes = (int) secondsleft/60;
        int seconds = secondsleft - minutes * 60;

        String secondString = seconds+"";

        if(seconds <= 9){
            secondString = "0"+seconds;
        }

        contador.setText(minutes+":"+secondString);
    }
}
