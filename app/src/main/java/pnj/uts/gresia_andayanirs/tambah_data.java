package pnj.uts.gresia_andayanirs;

import org.jetbrains.annotations.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import pnj.uts.gresia_andayanirs.adapter.adapterdat;
import pnj.uts.gresia_andayanirs.database.databasehelper;

public class tambah_data extends AppCompatActivity {
    RecyclerView recyclerView;

    databasehelper myDB;
    ArrayList<String> penduduk_id, nama, alamat, nik, tempat_lahir, tanggal_lahir, agama, telepon, kepala_keluarga;

    adapterdat customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        recyclerView = findViewById(R.id.recyleView);

        myDB = new databasehelper(tambah_data.this);
        penduduk_id = new ArrayList<>();
        nama = new ArrayList<>();
        alamat = new ArrayList<>();
        nik = new ArrayList<>();
        tempat_lahir = new ArrayList<>();
        tanggal_lahir = new ArrayList<>();
        agama = new ArrayList<>();
        telepon = new ArrayList<>();
        kepala_keluarga = new ArrayList<>();

        storeDataArrays();

        customAdapter = new adapterdat(tambah_data.this,tambah_data.this, penduduk_id, nama, alamat, nik, tempat_lahir, tanggal_lahir, agama, telepon, kepala_keluarga);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(tambah_data.this));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                penduduk_id.add(cursor.getString(0));
                nama.add(cursor.getString(1));
                alamat.add(cursor.getString(2));
                nik.add(cursor.getString(3));
                tempat_lahir.add(cursor.getString(4));
                tanggal_lahir.add(cursor.getString(5));
                agama.add(cursor.getString(6));
                telepon.add(cursor.getString(7));
                kepala_keluarga.add(cursor.getString(8));
            }
        }
    }
}