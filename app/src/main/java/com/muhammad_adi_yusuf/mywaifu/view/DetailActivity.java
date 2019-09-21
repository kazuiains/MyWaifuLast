package com.muhammad_adi_yusuf.mywaifu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhammad_adi_yusuf.mywaifu.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView foto;
    private TextView nama, anime, rilis, diskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        inisialisasi();
        getAndSetData();

    }

    private void inisialisasi(){
        foto = findViewById(R.id.img_char);
        nama = findViewById(R.id.tv_name);
        anime = findViewById(R.id.tv_anime);
        rilis = findViewById(R.id.tv_rilis);
        diskripsi = findViewById(R.id.deskrip);
    }

    private void getAndSetData(){
        int dataFoto = getIntent().getIntExtra("foto", 0);
        String dataAnime = getIntent().getStringExtra("anime");
        String dataNama = getIntent().getStringExtra("nama");
        String dataRilis = getIntent().getStringExtra("rilis");
        String dataDiskripsi = getIntent().getStringExtra("deskripsi");

        foto.setImageResource(dataFoto);
        nama.setText(dataNama);
        anime.setText(dataAnime);
        rilis.setText(dataRilis);
        diskripsi.setText(dataDiskripsi);
    }
}
