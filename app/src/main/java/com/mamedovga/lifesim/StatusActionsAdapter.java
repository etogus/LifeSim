package com.mamedovga.lifesim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamedovga.lifesim.models.StatusAction;

import java.util.List;

public class StatusActionsAdapter extends RecyclerView.Adapter<StatusActionsAdapter.MyViewHolder> {

    private List<StatusAction> list;
    private StatusActionsAdapter.ItemClickListener clickListener;

    public StatusActionsAdapter(List<StatusAction> list, StatusActionsAdapter.ItemClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public StatusActionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_status_actions_row, parent, false);
        return new StatusActionsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusActionsAdapter.MyViewHolder holder, int position) {
        holder.image.setImageResource(list.get(holder.getAdapterPosition()).getImage());
        holder.name.setText(list.get(holder.getAdapterPosition()).getName());
        holder.description.setText(list.get(holder.getAdapterPosition()).getDescription());

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
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.statusActionItemImage);
            name = itemView.findViewById(R.id.statusActionItemName);
            description = itemView.findViewById(R.id.statusActionItemDescription);
        }
    }

    public interface ItemClickListener {
        void onItemClick(StatusAction statusAction);
    }
}
