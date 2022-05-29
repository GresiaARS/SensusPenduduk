package pnj.uts.gresia_andayanirs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    SharedPreferences savelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savelogin = getSharedPreferences("SensusPenduduk",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(savelogin.getBoolean("login",false)){
                    Intent intent = new Intent(MainActivity.this,activityhome.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        },1000);
    }
}