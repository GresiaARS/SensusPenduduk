package pnj.uts.gresia_andayanirs.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pnj.uts.gresia_andayanirs.R;
import pnj.uts.gresia_andayanirs.updatedata;

public class adapterdat extends RecyclerView.Adapter<adapterdat.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList penduduk_id, nama, alamat, nik, tempat_lahir, tanggal_lahir, agama, telepon, kepala_keluarga;

    public adapterdat(Activity activity, Context context, ArrayList penduduk_id, ArrayList nama, ArrayList alamat, ArrayList nik, ArrayList tempat_lahir, ArrayList tanggal_lahir, ArrayList agama, ArrayList telepon, ArrayList kepala_keluarga){
        this.activity = activity;
        this.context = context;
        this.penduduk_id = penduduk_id;
        this.nama = nama;
        this.alamat = alamat;
        this.nik = nik;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.agama = agama;
        this.telepon = telepon;
        this.kepala_keluarga = kepala_keluarga;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.penduduk_id.setText(String.valueOf(penduduk_id.get(position)));
        holder.nama_penduduk.setText(String.valueOf(nama.get(position)));
        holder.alamatPenduduk.setText(String.valueOf(alamat.get(position)));
        holder.nik_penduduk.setText(String.valueOf(nik.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, updatedata.class);
                intent.putExtra("id", String.valueOf(penduduk_id.get(position)));
                intent.putExtra("nama", String.valueOf(nama.get(position)));
                intent.putExtra("alamat", String.valueOf(alamat.get(position)));
                intent.putExtra("nik", String.valueOf(nik.get(position)));
                intent.putExtra("tempat_lahir", String.valueOf(tempat_lahir.get(position)));
                intent.putExtra("tanggal_lahir", String.valueOf(tanggal_lahir.get(position)));
                intent.putExtra("agama", String.valueOf(agama.get(position)));
                intent.putExtra("telepon", String.valueOf(telepon.get(position)));
                intent.putExtra("kepala_keluarga", String.valueOf(kepala_keluarga.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return penduduk_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView penduduk_id, nama_penduduk, alamatPenduduk, nik_penduduk;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            penduduk_id = itemView.findViewById(R.id.penduduk_id);
            nama_penduduk = itemView.findViewById(R.id.nama_penduduk);
            alamatPenduduk = itemView.findViewById(R.id.alamatPenduduk);
            nik_penduduk = itemView.findViewById(R.id.nik_penduduk);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

