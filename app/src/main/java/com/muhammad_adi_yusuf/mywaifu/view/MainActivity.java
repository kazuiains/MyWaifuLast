package com.muhammad_adi_yusuf.mywaifu.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.muhammad_adi_yusuf.mywaifu.R;
import com.muhammad_adi_yusuf.mywaifu.modul.DataList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataList> dataList;
    private TypedArray dataFoto;
    private String[] dataName, dataAnimeName, dataDeskrip, dataRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InisialisasiArray();
        InputData();

        RecyclerView recyclerView = findViewById(R.id.rv_waifu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterRecycler adapter = new AdapterRecycler(this, dataList);
        recyclerView.setAdapter(adapter);

        ItemSupport.addTo(recyclerView).setOnItemClickListener(new ItemSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                DataList item = dataList.get(position);
                Intent intentJump = new Intent(getBaseContext(), DetailActivity.class);
                intentJump.putExtra("name", item.getName());
                intentJump.putExtra("anime", item.getAnimeName());
                intentJump.putExtra("rilis", item.getRelease());
                intentJump.putExtra("deskripsi", item.getDeskrip());
                intentJump.putExtra("foto", item.getFoto());
                startActivity(intentJump);

            }
        });
    }

    private void InputData() {
        dataList = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            DataList liSt = new DataList();
            liSt.setFoto(dataFoto.getResourceId(i, 1));
            liSt.setName(dataName[i]);
            liSt.setDeskrip(dataDeskrip[i]);
            liSt.setAnimeName(dataAnimeName[i]);
            liSt.setRelease(dataRelease[i]);
            dataList.add(liSt);
        }
    }

    private void InisialisasiArray() {
        dataName = getResources().getStringArray(R.array.name);
        dataAnimeName = getResources().getStringArray(R.array.anime);
        dataDeskrip = getResources().getStringArray(R.array.deskripsi);
        dataFoto = getResources().obtainTypedArray(R.array.foto);
        dataRelease = getResources().getStringArray(R.array.rilis);
    }

}
