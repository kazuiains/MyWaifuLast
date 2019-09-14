package com.muhammad_adi_yusuf.mywaifu.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muhammad_adi_yusuf.mywaifu.R;
import com.muhammad_adi_yusuf.mywaifu.modul.DataList;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    private Context context;
    private ArrayList<DataList> dataList;

    public AdapterRecycler(Context context, ArrayList<DataList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataList dataPosition = dataList.get(position) ;
        holder.imgFoto.setImageResource(dataPosition.getFoto());
        holder.txtName.setText(dataPosition.getName());
        holder.txtAnimeName.setText(dataPosition.getAnimeName());
        holder.txtDeskrip.setText(dataPosition.getDeskrip());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView txtName, txtAnimeName, txtDeskrip;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.image2);
            txtName = itemView.findViewById(R.id.txt_title);
            txtAnimeName = itemView.findViewById(R.id.txt_jdlanim);
            txtDeskrip = itemView.findViewById(R.id.deskrip);

        }
    }
}
