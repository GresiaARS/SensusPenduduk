package pnj.uts.gresia_andayanirs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import pnj.uts.gresia_andayanirs.fragment.fragmentberita;
import pnj.uts.gresia_andayanirs.fragment.fragmenthome;
import pnj.uts.gresia_andayanirs.fragment.fragmentprofile;

public class activityhome extends AppCompatActivity implements View.OnClickListener{
    ImageButton buat_home,buat_profile,buat_berita;
    fragmenthome FragmentHome = new fragmenthome();
    fragmentberita FragmentBerita = new fragmentberita();
    fragmentprofile FragmentProfile = new fragmentprofile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityhome);
        buat_home = findViewById(R.id.buat_home);
        buat_berita = findViewById(R.id.buat_berita);
        buat_profile = findViewById(R.id.buat_profile);

        buat_home.setOnClickListener(this);
        buat_berita.setOnClickListener(this);
        buat_profile.setOnClickListener(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container,FragmentBerita);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.buat_home:
                fragmentTransaction.replace(R.id.container,FragmentHome);
                fragmentTransaction.commit();
                break;

            case R.id.buat_berita:
                fragmentTransaction.replace(R.id.container,FragmentBerita);
                fragmentTransaction.commit();
                break;

            case R.id.buat_profile:
                fragmentTransaction.replace(R.id.container,FragmentProfile);
                fragmentTransaction.commit();
                break;

        }
    }

}
