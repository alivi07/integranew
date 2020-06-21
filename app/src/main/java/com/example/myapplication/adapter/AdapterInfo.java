package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailInfo;
import com.example.myapplication.R;
import com.example.myapplication.model.ModelInfo;

import java.util.ArrayList;

public class AdapterInfo extends RecyclerView.Adapter<AdapterInfo.ViewHolder> {
    private Context context;
    private ArrayList<ModelInfo> modelInfos;

    public AdapterInfo(Context context) {
        this.context = context;
    }

    public ArrayList<ModelInfo> getModelInfos() {
        return modelInfos;
    }

    public void setModelInfos(ArrayList<ModelInfo> modelInfos) {
        this.modelInfos = modelInfos;
    }

    @NonNull
    @Override
    public AdapterInfo.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_info, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterInfo.ViewHolder viewHolder, int i) {
        viewHolder.tvInfoList.setText(getModelInfos().get(i).getKataKunci());
    }

    @Override
    public int getItemCount() {
        return getModelInfos().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvInfoList;
        private LinearLayout linearlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInfoList = itemView.findViewById(R.id.tv_infolist);
            linearlayout = itemView.findViewById(R.id.linearlayout);
            linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailInfo.class);
                    intent.putExtra("id", getAdapterPosition());
                    intent.putExtra("title", tvInfoList.getText());
                    context.startActivity(intent);
                }
            });

        }
    }
}
