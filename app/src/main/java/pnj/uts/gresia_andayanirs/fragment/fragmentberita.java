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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.gresia_andayanirs.Login;
import pnj.uts.gresia_andayanirs.R;
import pnj.uts.gresia_andayanirs.adapter.adapterList;
import pnj.uts.gresia_andayanirs.detail;
import pnj.uts.gresia_andayanirs.model.modelList;
import pnj.uts.gresia_andayanirs.nambahin;
import pnj.uts.gresia_andayanirs.tambah_data;

public class fragmentberita extends Fragment {
    ListView list_v;
    adapterList adapterlist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_v = view.findViewById(R.id.list_v);
        adapterlist = new adapterList(getContext(),R.layout.item_sinopsis);
        list_v.setAdapter(adapterlist);
        nambahin();

        list_v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                modelList data = (modelList) parent.getAdapter().getItem(position);
                Intent intent = new Intent(getContext(), detail.class);
                intent.putExtra("gambar", data.getGambar());
                intent.putExtra("judul", data.getJudul());
                intent.putExtra("sinopsis", data.getSinopsis());
                startActivity(intent);
            }
        });
    }

    void nambahin() {
        modelList data1 = new modelList();
        data1.setGambar("https://cdns.klimg.com/merdeka.com/i/w/news/2021/11/11/1374952/670x335/bawaslu-dorong-verifikasi-sensus-penduduk-cegah-kecurangan-pemilu-via-jual-beli-data.jpg");
        data1.setJudul("Bawaslu Dorong Verifikasi Sensus Penduduk Cegah Kecurangan Pemilu Via Jual Beli Data");
        data1.setSinopsis("Merdeka.com - Koordinator Divisi Hukum, Humas, Data, dan Informasi Badan Pengawas Pemilihan Umum (Bawaslu) Fritz Edward Siregar mengatakan bahwa terdapat potensi kecurangan pemilu akibat maraknya jual beli data pribadi milik warga negara Indonesia.\n" +
                "\"Sebagaimana yang kalian ketahui, sekarang kita agak heboh dengan data warga negara yang diperjualbelikan. Itu menjadi concern (perhatian) Bawaslu,\" kata Fritz pada acara Sidak Bawaslu Kota Cilegon, Banten, Kamis (11/11).\n" +
                "\n" +
                "Fritz memaparkan bahwa kecurangan yang dapat diakibatkan oleh penjualan data tersebut adalah potensi kecurangan pada saat pendaftaran partai politik untuk mengikuti pemilihan umum, serta pendaftaran calon independen untuk pemilihan kepala daerah.\n" +
                "\n" +
                "\"Kan pendaftaran partai politik ada seperseribu dari jumlah penduduk untuk memasukkan jumlah anggota partai politiknya, itu kan bisa saja data-data (warga negara yang diperjualbelikan) tersebut dipakai,\" tuturnya.\n" +
                "\n" +
                "Oleh karena itu, Fritz mengatakan bahwa harus ada proses verifikasi melalui sensus untuk memastikan kebenaran data yang digunakan oleh partai politik atau calon independen pada saat mendaftarkan diri sebagai peserta pemilihan.\n" +
                "\n" +
                "\"Harus ada proses verifikasi yang lebih detail oleh KPU (Komisi Pemilihan Umum) dan Bawaslu diberikan kesempatan untuk melihat hasil dari verifikasi tersebut,\" ucapnya.\n" +
                "\n" +
                "Menggunakan data warga negara yang diperjualbelikan oleh pihak peretas atau pihak ketiga merupakan salah satu tindakan ilegal. Menggunakan data tersebut, ia melanjutkan, dapat mengakibatkan pihak-pihak yang terlibat terkena sanksi akibat pelanggaran hukum pidana.\n" +
                "\n" +
                "\"Mereka akan dikenakan pelanggaran hukum pidana, baik karena melanggar Undang-Undang Pemilu maupun pelanggaran Undang-Undang Pidana, misalnya memalsukan tanda tangan. Kami sebagai Bawaslu memperingatkan pihak-pihak agar tidak menggunakan data tersebut dalam proses Pemilu maupun Pilkada 2024,\" tutur dia.\n" +
                "\n" +
                "\"Simpang tiga Sriwedari, bundaran Gladak dan di jalan Jenderal Sudirman, Pasar Kliwon. Dari serangkaian kegiatan penguraian massa telah diamankan sepeda motor para Suporter Persis Solo sebanyak sembilan unit dan dibawa ke Mako 2 Polresta Solo,\" tuturnya.\n" +
                "\n" +
                "Saat ini, Fritz mengatakan bahwa Bawaslu sedang melakukan perbaikan, baik perbaikan pada sistem informasi serta sistem pelanggaran-pelanggaran untuk memaksimalkan penyelenggaraan pemilu serentak 2024.\n" +
                "\n" );

        modelList data2 = new modelList();
        data2.setGambar("https://akcdn.detik.net.id/community/media/visual/2020/09/18/berharganya-sensus-penduduk-2020_169.jpeg?w=700&q=90");
        data2.setJudul("Sensus Penduduk 2020 Selesai, Begini Sebaran Masyarakat RI Terbaru");
        data2.setSinopsis("Jakarta - Badan Pusat Statistik (BPS) dan Kementerian Dalam Negeri kemarin merilis hasil sementara tentang data penghitungan jumlah penduduk terbaru. BPS merilis Data Sensus Penduduk 2020, sedangkan Kemendagri merilis Data Administrasi Kependudukan 2020.\n" +
                "Menurut hasil Data Administrasi Kependudukan per Desember 2020, jumlah penduduk Indonesia saat ini sebanyak 271.349.889 jiwa. Terdiri dari 134.229.988 jiwa perempuan dan 137.119.901 jiwa laki-laki. Sedangkan jumlah kartu keluarga mencapai 86.437.053.\n" +
                "\n" +
                "Dari total jumlah penduduk itu paling banyak berada di pulau Jawa sebesar 55,94%, disusul Sumatera 21,73%, Sulawesi 7,43%, Kalimantan 6,13%, Bali dan Nusa Tenggara 5,57%, Papua 2,02% dan Maluku 1,17%.\n" +
                "\n" +
                "Data itu diambil dari jumlah perekaman di 2020 dari sebanyak 196.394.976 wajib KTP yang sudah terekam sebanyak 194.649.012 atau mencapai 99,11%. Sementara sisa wajib KTP yang belum terekam sebanyak 1.745.964 akan dilakukan di 2021.\n" +
                "\n" +
                "Tahun ini target perekaman KTP sebanyak 5.777.755, terdiri dari sisa wajib KTP yang belum terekam di 2020 ditambah wajib KTP pemula sebanyak 4.031.791. Sehingga totalnya menjadi 200.426.767 wajib KTP yang direkam.\n" +
                "\n" +
                "Sementara BPS merilis Data Sensus Penduduk yang dilakukan baur sampai September 2020. BPS pun mencatat jumlah penduduk masyarakat Indonesia mencapai 270,2 juta jiwa.\n" +
                "\n" +
                "\"Jika dibandingkan dengan sensus penduduk terdahulu kita bisa lihat bahwa jumlah penduduk Indonesia dari waktu ke waktu terus mengalami peningkatan,\" kata Kepala BPS Suhariyanto.\n" +
                "\n" +
                "Menurut data BPS, dengan luas daratan Indonesia sebesar 1,9 juta km2, maka kepadatan penduduk Indonesia pada tahun 2020 adalah sebanyak 141 jiwa per km2. Lalu selama tahun 2010 sampai dengan tahun 2020 rata-rata laju pertumbuhan penduduk Indonesia adalah sebesar 1,25% per tahun.\n" +
                "\n" +
                "\"Laju pertumbuhan penduduk terjadi karena dipengaruhi oleh faktor kelahiran, kematian dan juga faktor migrasi,\" tambahnya.\n" +
                "\n" +
                "Suhariyanto menjelaskan, jumlah penduduk Indonesia masih paling banyak berada di pulau Jawa sebesar 151,6 juta jiwa atau 56,1%, diikuti Sumatera 58,6 juta jiwa atau 21,68%, lalu Sulawesi 19,9 juta jiwa atau 7,36%, Kalimantan 16,6 juta jiwa atau 6,15%, Bali-Nusa Tenggara 15 juta jiwa atau 5,54% dan Maluku-Papua 8,6 juta jiwa atau 3,17%.\n" +
                "\n" +
                "Meski penduduk pulau Jawa yang paling banyak, ternyata jumlah penduduknya terus berkurang karena adanya pergeseran penduduk.\n" +
                "\n" +
                "\"Kalau dibandingkan hasil sensus penduduk 2020 ini dengan hasil sensus penduduk sebelumnya, sebenarnya terjadi pergeseran penduduk antar pulau dari waktu ke waktu,\" tuturnya.\n" +
                "\n" +
                "Misalnya dari hasil Sensus Penduduk di 2000 penduduk yang tinggal di Jawa mencapai 59,1%. Kemudian hasil Sensus Penduduk di 2010 turun menjadi 57,5% dan hasil 2020 ini turun lagi jadi 56,1%.\n" +
                "\n" +
                "Sebaliknya penduduk di Kalimantan persentasenya mengalami peningkatan dari 5,5% dari hasil Sensus Penduduk di 2000 menjadi 6,15% di 2020.\n" +
                "\n" +
                "\"Namun harus diakui bahwa pergeseran ini bergerak sangat lambat karena ini terkait erat dengan potensi ekonomi dan juga infrastruktur yang ada,\" terangnya.\n" +
                "\n");

        modelList data3 = new modelList();
        data3.setGambar("https://akcdn.detik.net.id/community/media/visual/2019/09/06/3dd2e7e5-46f8-4f09-98c8-26451c5d020f_169.jpeg?w=700&q=90");
        data3.setJudul("Polisi Dalami Penyebab Lain yang Bikin Tangki Pertamina di Cilacap Terbakar");
        data3.setSinopsis("Jakarta - Polisi merilis kesimpulan sementara bahwa kebakaran yang terjadi di tangki milik PT Pertamina di Cilacap diakibatkan oleh sambaran petir. Namun polisi beserta Pertamina masih mendalami penyebab lain yang mengakibatkan tangki milik Pertamina itu terbakar.\n" +
                "\"Tim Labfor, Inafis, serta tim gabungan dengan para ahli, serta Pertamina, masih mendalami,\" ujar Kadiv Humas Polri Irjen Dedi Prasetyo saat ditemui di Mabes Polri, Jakarta Selatan, Selasa (16/11/2021).\n" +
                "\n" +
                "Dedi menjelaskan, bukan tidak mungkin apabila ditemukan penyebab lain selain petir yang mengakibatkan kilang terbakar. Pasalnya, tim gabungan masih bekerja.\n" +
                "\n" +
                "\"Tapi tidak menutup kemungkinan dari hasil pemeriksaan tim terpadu nanti akan di-publish kembali. Apakah ada unsur-unsur terkait lainnya,\" tuturnya.\n" +
                "\n" +
                "Meski demikian, berdasarkan pemeriksaan saksi dan bukti yang dikumpulkan, Dedi mengatakan, kilang terbakar karena tersambar petir.\n" +
                "\n" +
                "\"Memang sudah statement Kapolda Jateng kemarin sudah membuat suatu kesimpulan sementara, dugaan adalah karena tersambar petir,\" kata Dedi.\n" +
                "\n" +
                "\"Yang jelas dugaan dari berbagai macam bukti yang dimiliki dan 6 saksi yang sudah diperiksa, sementara ini mengarah kepada alam, alam dalam hal ini adalah petir,\" imbuhnya.\n" +
                "\n" +
                "Sebelumnya, Kapolda Jawa Tengah Irjen Ahmad Luthfi mengatakan kebakaran di tangki Pertamina Cilacap terjadi akibat sambaran petir. Luthfi menyebut peristiwa itu sama dengan kebakaran pada Juni lalu.\n" +
                "\n" +
                "\"Jadi (kejadian) Juni kemarin sama. Sudah kita periksa ahli, Profesor Zoro (Reynaldo Zoro) dari ITB terkait kekuatan petir yang juga menyambar dari antena penangkal yang tidak kuat sehingga menyebabkan kebakaran, karena di sini kan daerah petir,\" kata Luthfi kepada wartawan saat konferensi pers di Gedung Patra Graha Pertamina Cilacap.\n" +
                "\n" +
                "Peristiwa kebakaran tangki di PT KPI Unit Cilacap itu terjadi pada Sabtu (13/11) pukul 19.10 WIB. Kebakaran unit tangki itu terjadi saat hujan deras disertai petir.\n" +
                "\n");

        modelList data4 = new modelList();
        data4.setGambar("https://akcdn.detik.net.id/community/media/visual/2015/09/01/6f19cdc8-104f-4451-a2ee-7440d3b426d9_169.jpg?w=700&q=90");
        data4.setJudul("Hitung-hitungan Kenaikan UMP Jakarta 2022: Nggak Sampai Rp 50 Ribu!");
        data4.setSinopsis("Jakarta - Kementerian Ketenagakerjaan telah mengumumkan hasil penghitungan penyesuaian nilai UMP dan UMK 2022 berdasarkan data Badan Pusat Statistik (BPS). Dalam data itu tercatat UMP Jakarta 2022 masih jadi yang tertinggi. Sedangkan di sisi lain, nilai UMP terendah ada di wilayah Jawa Tengah.\n" +
                "\"Data statistik Upah Minimum, UMP terendah Jawa Tengah Rp 1.813.011 dan UMP tertinggi DKI Jakarta Rp 4.453.724. Rata-rata penyesuaian UMP adalah 1,09%,\" kata Direktur Jenderal Pembinaan Hubungan Industrial dan Jaminan Sosial Tenaga Kerja, Indah Anggoro Putri dalam Seminar Terbuka Proses Penetapan Upah Minimum 2022 secara virtual, Senin (15/11/2021).\n" +
                "\n" +
                "Bila UMP Jakarta 2022 benar Rp 4.453.724, maka kenaikannya tak sampai Rp 50 ribu dari tahun ini. Sebab, UMP Jakarta 2021 sebesar Rp 4.416.186. Dengan demikian, kenaikannya hanya sekitar Rp 37.500.\n" +
                "\n" +
                "Kemudian, Indah menyampaikan kalau pertumbuhan ekonomi tertinggi didapat oleh Maluku Utara dengan kenaikan 12,76%, pertumbuhan ekonomi terendah yakni Bali -5,83%. Inflasi tertinggi Bangka Belitung 3,29% dan Inflasi terendah Papua -0,40%.\n" +
                "\n" +
                "Diungkapkan juga dari 24 Provinsi, ada 4 Provinsi yang nilai UM tahun 2021 lebih tinggi dari Batas Atas upah Minimum. Sehingga UM tahun 2022 ditetapkan nilainya sama dengan upah minimum 2021.\n" +
                "\n" +
                "Diungkapkan juga dari 24 Provinsi, ada 4 Provinsi yang nilai UM tahun 2021 lebih tinggi dari Batas Atas upah Minimum. Sehingga UM tahun 2022 ditetapkan nilainya sama dengan upah minimum 2021.\n" +
                "\n" +
                "\"Keempat provinsi itu, Sumatera Selatan Rp 3.144.446, Sulawesi Utara Rp 3.310.723, Sulawesi Selatan Rp 3.165.876, dan Sulawesi Barat Rp 2.678.863,\" jelasnya.\n" +
                "\n" +
                "Sementara perihal Upah Minimum Kabupaten/Kota, dari 24 Provinsi terdapat 26 Provinsi yang telah menetapkan UMK. Dari Kabupaten/Kota di 26 Provinsi sebanyak 255 Kabupaten/Kota yang tela menetapkan UMK. \"Namun, ada 42 UMK yang tidak mengalami penyesuaian dengan rincian,\" paparnya.\n" +
                "\n" +
                "Hasilnya, kenaikan nilai UMK tertinggi di Kota Palu sebesar Rp 174.840 dan kenaikan UMK terendah di Kabupaten Padang Lawas Utara sebesar Rp 277.\n" +
                "\n" +
                "Lebih lanjut, penetapan UMP ini harus diumumkan oleh Gubernur paling lambat 21 November 2021. Sementara upah minimum kabupaten/kota (UMK) paling lambat pada 30 November 2021. Penyesuaian upah minimum ini disesuaikan dengan formula PP 36/2021.\n" +
                "\n" +
                "\"Upah minimum ditetapkan oleh Kemenaker, itu jawabannya salah. Yang menetapkan adalah Gubernur yang menetapkan Upah Minimum Provinsi, paling lambat 21 November 2021 ini, sekitar 6 hari lagi. Karena 21 itu hari minggu maka harus ditetapkan sehari sebelum hari libur,\" ungkapnya.\n" +
                "\n" +
                "\"Mungkin bukan Gubernur yang utak-atik ada Dewan Pengupahan Daerah, Dinar Tenaga Kerja, bekerjasama untuk menghitung dengan formula yang ada, lalu dilaporkan kepada Gubernur untuk menjadi ketetapan UMP,\" imbuhnya.\n" +
                "\n" +
                "Dengan demikian, pada akhirnya penetapan UMP dan UMK akan tetap dilakukan oleh Gubernur di masing-masing Provinsi. Termasuk di dalamnya penetapan UMP Jakarta 2022 yang akan diteken oleh Anies Baswedan selaku Gubernur DKI Jakarta.\n" +
                "\n");

        modelList data5 = new modelList();
        data5.setGambar("https://akcdn.detik.net.id/community/media/visual/2021/05/19/kabag-penum-divisi-humas-polri-kombes-ahmad-ramadhan_169.jpeg?w=700&q=90");
        data5.setJudul("Polri Benarkan Densus 88 Tangkap Farid Okbah-Zain An Najah");
        data5.setSinopsis("Jakarta - Detasemen Khusus (Densus) 88 Antiteror menangkap Ketua Umum Partai Dakwah Rakyat Indonesia (PDRI) Ustaz Farid Okbah dan Ahmad Zain An Najah. Polri belum menjelaskan detail alasan penangkapan.\n" +
                "\"Ya, benar. Keduanya,\" ujar Kabag Penum Divisi Humas Polri Kombes Ahmad Ramadhan saat dimintai konfirmasi, Selasa (16/11/2021).\n" +
                "\n" +
                "Ramadhan mengatakan keduanya ditangkap hari ini. Namun ia belum menjelaskan detail kronologi penangkapan.\n" +
                "\n" +
                "\"Hari ini, itu dulu ya,\" tuturnya.\n" +
                "\n" +
                "Ahmad Zain An Najah tercatat sebagai anggota Komisi Fatwa MUI Pusat. Nama tersebut tercatat di nomor 24.\n" +
                "\n" +
                "Sebelumnya, Farid Okbah dikabarkan ditangkap Densus 88. Selain Farid, Ahmad Zain An Najah dikabarkan turut ditangkap.\n" +
                "\n" +
                "Hal itu dibenarkan oleh salah satu Tim Pengacara Muslim (TPM), Achmad Michdan. Dia menyebut ada tiga orang yang diamankan, dua di antaranya Ustaz Farid Okbah dan Ustaz Ahmad Zain An Najah.\n" +
                "\n" +
                "\"Betul infonya gitu, turut diamankan, beliau diduga pendakwah juga,\" kata Achmad kepada detikcom, Selasa (16/11).\n" +
                "\n" +
                "\"Jadi tiga orang diamankan yang saya sempat dengar namanya Farid Okbah, dan yang tadi namanya disebut (Ustaz Ahmad Zain An Najah) iya, satu lagi saya nggak ingat namanya,\" tambah Achmad.\n" +
                "\n");

        adapterlist.add(data1);
        adapterlist.add(data2);
        adapterlist.add(data3);
        adapterlist.add(data4);
        adapterlist.add(data5);
        adapterlist.notifyDataSetChanged();

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

