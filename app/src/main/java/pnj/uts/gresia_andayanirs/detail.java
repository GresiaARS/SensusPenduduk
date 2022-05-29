package pnj.uts.gresia_andayanirs;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class detail extends AppCompatActivity {
    ImageView gambar;
    TextView judul,sinopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        judul = findViewById(R.id.judulv2);
        sinopsis = findViewById(R.id.sinop);
        gambar = findViewById(R.id.pict);


        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            Picasso.get()
                    .load(extra.getString("gambar",""))
                    .into(gambar);
            judul.setText(extra.getString("judul",""));
            sinopsis.setText(extra.getString("sinopsis",""));

        }
    }
}
