package pnj.uts.gresia_andayanirs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Sensus_Penduduk.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "data_penduduk";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_ALAMAT = "alamat";
    private static final String COLUMN_NIK = "nik";
    private static final String COLUMN_TEMPAT_LAHIR = "tempat_lahir";
    private static final String COLUMN_TANGGAL_LAHIR = "tanggal_lahir";
    private static final String COLUMN_AGAMA = "agama";
    private static final String COLUMN_TELEPON = "telepon";
    private static final String COLUMN_KEPALA_KELUARGA = "kepala_keluarga";


    public databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAMA + " TEXT, " +
                        COLUMN_ALAMAT + " TEXT, " +
                        COLUMN_NIK + " INTEGER, " +
                        COLUMN_TEMPAT_LAHIR + " TEXT, " +
                        COLUMN_TANGGAL_LAHIR + " TEXT, " +
                        COLUMN_AGAMA + " TEXT, " +
                        COLUMN_TELEPON + " TEXT, " +
                        COLUMN_KEPALA_KELUARGA + " TEXT" +
                        ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String nama, String alamat, int nik, String tempat_lahir, String tanggal_lahir, String agama, String nomor_telepon, String kepala_keluarga) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_ALAMAT, alamat);
        cv.put(COLUMN_NIK, nik);
        cv.put(COLUMN_TEMPAT_LAHIR, tempat_lahir);
        cv.put(COLUMN_TANGGAL_LAHIR, tanggal_lahir);
        cv.put(COLUMN_AGAMA, agama);
        cv.put(COLUMN_TELEPON, nomor_telepon);
        cv.put(COLUMN_KEPALA_KELUARGA, kepala_keluarga);
        long resault = db.insert(TABLE_NAME, null, cv);
        if (resault == -1) {
            Toast.makeText(context, "Gagal Menambahkan Data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ditambahkan✔️", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateData(String row_id, String nama, String alamat, int nik, String tempat_lahir, String tanggal_lahir, String agama, int nomor_telepon, String kepala_keluarga) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_ALAMAT, alamat);
        cv.put(COLUMN_NIK, nik);
        cv.put(COLUMN_TEMPAT_LAHIR, tempat_lahir);
        cv.put(COLUMN_TANGGAL_LAHIR, tanggal_lahir);
        cv.put(COLUMN_AGAMA, agama);
        cv.put(COLUMN_TELEPON, nomor_telepon);
        cv.put(COLUMN_KEPALA_KELUARGA, kepala_keluarga);
        long resault = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (resault == -1) {
            Toast.makeText(context, "Gagal Memperbaharui Data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Diperbaharui✔️", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

    public void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long resault = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (resault == -1) {
            Toast.makeText(context, "Gagal Menghapus Data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Dihapus ❌", Toast.LENGTH_SHORT).show();
        }
    }
}
