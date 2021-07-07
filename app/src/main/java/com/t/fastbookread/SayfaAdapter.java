package com.t.fastbookread;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SayfaAdapter extends RecyclerView.Adapter<SayfaAdapter.ViewHolder> {

    private List<SayfaModel> sayfaModelList;

    public SayfaAdapter(List<SayfaModel> sayfaModelList) {
        this.sayfaModelList = sayfaModelList;
    }

    @NonNull
    @Override
    public SayfaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sayfa_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SayfaAdapter.ViewHolder holder, int position) {
        holder.setData(sayfaModelList.get(position).getBaslik(),sayfaModelList.get(position).getIcerik(),position);
    }

    @Override
    public int getItemCount() {
        return sayfaModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView baslik;
        private TextView icerik;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            baslik = itemView.findViewById(R.id.baslik);
            icerik = itemView.findViewById(R.id.icerik);
        }

        public void setData(String baslik1, String icerik1, int position) {
            baslik.setText(baslik1);
            icerik.setText(icerik1);
        }

    }
}
