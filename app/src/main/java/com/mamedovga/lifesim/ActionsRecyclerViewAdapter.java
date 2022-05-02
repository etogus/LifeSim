package com.mamedovga.lifesim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamedovga.lifesim.models.BasicAction;

import java.util.List;

public class ActionsRecyclerViewAdapter extends RecyclerView.Adapter<ActionsRecyclerViewAdapter.MyViewHolder> {

    private List<BasicAction> list;
    private ActionsRecyclerViewAdapter.ItemClickListener clickListener;

    public ActionsRecyclerViewAdapter(List<BasicAction> list, ActionsRecyclerViewAdapter.ItemClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ActionsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_actions_row, parent, false);
        return new ActionsRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionsRecyclerViewAdapter.MyViewHolder holder, int position) {
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
            image = itemView.findViewById(R.id.actionImage);
            name = itemView.findViewById(R.id.actionName);
            description = itemView.findViewById(R.id.actionDescription);
        }
    }

    public interface ItemClickListener {
        void onItemClick(BasicAction basicAction);
    }
}
