package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.DetailInfo;
import com.example.myapplication.MainActivity3;
import com.example.myapplication.R;
import com.example.myapplication.model.AbsenItem;
import com.example.myapplication.model.User;
import com.example.myapplication.util.PrefUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterLaporan extends RecyclerView.Adapter<AdapterLaporan.ViewHolder> {
    private List<AbsenItem> absenItems = new ArrayList<>();
   // List<AbsenItem> Items;
    private Context context;

    public AdapterLaporan(Context context) {
        this.context = context;
    }

    public void setData(List<AbsenItem> items) {
        absenItems.clear();
        absenItems.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AdapterLaporan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laporan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLaporan.ViewHolder holder, int position) {
       // AbsenItem absenItems = Items.get(position);
        holder.tvtanggal.setText(absenItems.get(position).getTanggal());
        holder.tvtjamdatang.setText(absenItems.get(position).getJamDatang());
        holder.tvjampulang.setText(absenItems.get(position).getJamPulang());
        holder.tvketjamdatang.setText(absenItems.get(position).getKetMasuk());
        holder.tvketjampulang.setText(absenItems.get(position).getKetPulang());

    }

    @Override
    public int getItemCount() {
        return absenItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        User user = PrefUtil.getUser(context, PrefUtil.USER_SESSION);
        TextView tvtanggal, tvtjamdatang, tvjampulang, tvketjamdatang, tvketjampulang;
        LinearLayout layoutItemList;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvtanggal = itemView.findViewById(R.id.tv_tanggal);
            tvtjamdatang = itemView.findViewById(R.id.tvjam_datang);
            tvjampulang = itemView.findViewById(R.id.tvket_jam_pulang);
            tvketjamdatang = itemView.findViewById(R.id.tvket_jam_datang);
            tvketjampulang = itemView.findViewById(R.id.tvket_jam_pulang);


//            layoutItemList = itemView.findViewById(R.id.item_list_laporan);
//            layoutItemList.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent = new Intent(context, MainActivity3.class);
//
//                    intent.putExtra("tanggal", absenItems.get(getAdapterPosition()).getTanggal());
//                    intent.putExtra("jamdatang", absenItems.get(getAdapterPosition()).getJamDatang());
//                    intent.putExtra("jampulang", absenItems.get(getAdapterPosition()).getJamPulang());
//                    intent.putExtra("ketjamdatang", absenItems.get(getAdapterPosition()).getKetMasuk());
//                    intent.putExtra("ketjampulang", absenItems.get(getAdapterPosition()).getKetPulang());
//                    v.getContext().startActivity(intent);
//                }
//            });
        }
    }
}
