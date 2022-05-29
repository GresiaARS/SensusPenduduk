package pnj.uts.gresia_andayanirs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pnj.uts.gresia_andayanirs.database.databasehelper;

public class nambahin extends AppCompatActivity {

    EditText nama, alamat, nik, tempat_lahir, tanggal_lahir, agama, telepon, kepala_keluarga;
    Button add_button;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText btDatePicker;

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                btDatePicker.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nambahin);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        btDatePicker = (EditText) findViewById(R.id.tanggal_lahir);

        nama = findViewById(R.id.nama_input);
        alamat = findViewById(R.id.alamat_input);
        nik = findViewById(R.id.nik_input);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        tanggal_lahir = findViewById(R.id.tanggal_lahir);
        agama = findViewById(R.id.agama);
        telepon = findViewById(R.id.tlp);
        kepala_keluarga = findViewById(R.id.kepala_keluarga);
        add_button = findViewById(R.id.update_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper myDB = new databasehelper(nambahin.this);
                myDB.addData(nama.getText().toString().trim(),
                        alamat.getText().toString().trim(),
                        Integer.valueOf(nik.getText().toString().trim()),
                        tempat_lahir.getText().toString().trim(),
                        tanggal_lahir.getText().toString().trim(),
                        agama.getText().toString().trim(),
                        telepon.getText().toString().trim(),
                        kepala_keluarga.getText().toString().trim()
                );
                finish();
            }
        });
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        btDatePicker = (EditText) findViewById(R.id.tanggal_lahir);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
    }
}