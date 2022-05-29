package pnj.uts.gresia_andayanirs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.squareup.picasso.Picasso;

import pnj.uts.gresia_andayanirs.R;
import pnj.uts.gresia_andayanirs.model.modelList;


public class adapterList extends ArrayAdapter<modelList> {
    Context context;
    int resouce;
    public adapterList(@NonNull Context context, int resource) {
        super(context, resource);
        this.context=context;
        this.resouce=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        modelList data = getItem(position);

        if (convertView==null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resouce,parent,false);
            holder.gambar = convertView.findViewById(R.id.pict);
            holder.judul = convertView.findViewById(R.id.judulv2);
            holder.sinopsis = convertView.findViewById(R.id.sinop);

            convertView.setTag(holder);


        }else{
            holder = (Holder) convertView.getTag();
        }
        Picasso.get()
                .load(data.getGambar())
                .resize(100, 100)
                .centerCrop()
                .into(holder.gambar);
        holder.judul.setText(data.getJudul());
        holder.sinopsis.setText(data.getSinopsis());

        return convertView;
    }
    class Holder{
        ImageView gambar;
        TextView judul,sinopsis;

    }
}
