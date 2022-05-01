package com.mamedovga.lifesim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamedovga.lifesim.models.NonPlayableCharacter;

import java.util.List;

public class RelationshipsRecyclerViewAdapter extends RecyclerView.Adapter<RelationshipsRecyclerViewAdapter.MyViewHolder> {

    private List<NonPlayableCharacter> list;
    private ItemClickListener clickListener;

    public RelationshipsRecyclerViewAdapter(List<NonPlayableCharacter> list, ItemClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RelationshipsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_relationships_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelationshipsRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.avatar.setImageResource(list.get(holder.getAdapterPosition()).getAvatar());
        holder.name.setText(list.get(holder.getAdapterPosition()).getFullName());
        holder.statusToPlayer.setText(list.get(holder.getAdapterPosition()).getStatusToPlayer());

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

        ImageView avatar;
        TextView name;
        TextView statusToPlayer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.npcAvatar);
            name = itemView.findViewById(R.id.npcName);
            statusToPlayer = itemView.findViewById(R.id.npcStatusToPlayer);
        }
    }

    public interface ItemClickListener {
        void onItemClick(NonPlayableCharacter nonPlayableCharacter);
    }
}
