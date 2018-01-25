package id.co.imastudio.lab6ormlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.co.imastudio.lab6ormlite.activity.EditAnggotaActivity;

/**
 * Created by idn on 1/24/2018.
 */

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MyViewHolder> {
    private Context context;
    private List<ModelAnggota> listData = new ArrayList<>();

    //constructor
    public AnggotaAdapter(Context context, List<ModelAnggota> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //sambungkan list_item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set data
        holder.tvNama.setText(listData.get(position).getNama());
        holder.tvAlamat.setText(listData.get(position).getAlamat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, EditAnggotaActivity.class);
                // kirim data
                pindah.putExtra("DATA_ANGGOTA", (Serializable) listData);
                pindah.putExtra("DATA_POSISI", position);


                pindah.putExtra("DATA_ID", listData.get(position).getId());
                pindah.putExtra("DATA_NAMA", listData.get(position).getNama());
                pindah.putExtra("DATA_ALAMAT", listData.get(position).getAlamat());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        //hitung jml list
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //sambungkan komponen
        TextView tvNama;
        TextView tvAlamat;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvAlamat = itemView.findViewById(R.id.tv_item_alamat);
        }
    }
}
