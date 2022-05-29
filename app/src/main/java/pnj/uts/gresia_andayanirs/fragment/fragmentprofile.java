package pnj.uts.gresia_andayanirs.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.gresia_andayanirs.Login;
import pnj.uts.gresia_andayanirs.R;
import pnj.uts.gresia_andayanirs.nambahin;
import pnj.uts.gresia_andayanirs.tambah_data;

public class fragmentprofile extends Fragment {
    TextView edit_email;

    public static fragmentprofile  newInstance(String data) {

        Bundle args = new Bundle();
        args.putString("name",data);
        fragmentprofile fragment = new fragmentprofile();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_tambah:
                Intent pindahmenutambah = new Intent(getActivity(), nambahin.class);
                startActivity(pindahmenutambah);
                break;

            case R.id.menu_data:
                Intent pindahmenuedit = new Intent(getActivity(), tambah_data.class);
                startActivity(pindahmenuedit);
                break;

            case R.id.menu_logout:
                SharedPreferences savelogin = getActivity().getSharedPreferences("SensusPenduduk", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = savelogin.edit();
                edit.clear();
                edit.commit();

                Intent pindah = new Intent(getActivity(), Login.class);
                startActivity(pindah);
                getActivity().finish();
                Toast.makeText(getContext(),"logout",Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}

