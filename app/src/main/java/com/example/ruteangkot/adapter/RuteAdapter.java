package com.example.ruteangkot.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ruteangkot.Detail;
import com.example.ruteangkot.R;
import com.example.ruteangkot.model.RuteAngkotItem;

import java.util.ArrayList;

public class RuteAdapter extends RecyclerView.Adapter<RuteAdapter.ViewHolder> {
    private ArrayList<RuteAngkotItem> mRuteData;
    private Context mContext;

    public RuteAdapter(ArrayList<RuteAngkotItem> mRuteData, Context mContext) {
        this.mRuteData = mRuteData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_rute, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTrayek.setText(mRuteData.get(position).getTrayek());
        Glide.with(mContext).load(mRuteData.get(position).getGambarUrl()).error(R.mipmap.ic_launcher).override(512, 512).into(holder.mRuteImage);
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Detail.class);
                intent.putExtra("trayek", mRuteData.get(position).getTrayek());
                intent.putExtra("lintasan", mRuteData.get(position).getLintasan());
                intent.putExtra("gambar_url", mRuteData.get(position).getGambarUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRuteData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTrayek;
        private ImageView mRuteImage;
        private TextView mLintasan;

        private CardView cardClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTrayek = itemView.findViewById(R.id.ruteTrayek);
            mLintasan = itemView.findViewById(R.id.ruteLintasan);
            mRuteImage = itemView.findViewById(R.id.ruteImage);
            cardClick = itemView.findViewById(R.id.card_view);
        }
    }
}
