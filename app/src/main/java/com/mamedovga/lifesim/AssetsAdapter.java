package com.mamedovga.lifesim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamedovga.lifesim.models.AbstractAsset;

import java.util.List;

public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.MyViewHolder> {

    private List<AbstractAsset> list;
    private ItemClickListener clickListener;

    public AssetsAdapter(List<AbstractAsset> list, ItemClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AssetsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_assets_row, parent, false);
        return new AssetsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssetsAdapter.MyViewHolder holder, int position) {
        holder.image.setImageResource(list.get(holder.getAdapterPosition()).getImage());
        holder.name.setText(list.get(holder.getAdapterPosition()).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.assetImage);
            name = itemView.findViewById(R.id.assetName);
        }

    }

    public interface ItemClickListener {
        void onItemClick(AbstractAsset abstractAsset);
    }
}
