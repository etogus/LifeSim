package com.mamedovga.lifesim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mamedovga.lifesim.models.Chat;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {
    private ArrayList<Chat> chatArrayList;
    private Context context;

    public ChatAdapter(ArrayList<Chat> chatArrayList, Context context) {
        this.chatArrayList = chatArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_message_item, parent, false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_response_item, parent, false);
                return new UserViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = chatArrayList.get(position);
        switch (chat.getSender()) {
            case "user":
                ((UserViewHolder) holder).userMessage.setText(chat.getMessage());
                break;
            case "bot":
                ((BotViewHolder) holder).botResponse.setText(chat.getMessage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatArrayList.get(position).getSender()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userMessage;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userMessage = itemView.findViewById(R.id.userMessage);
        }
    }

    public static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView botResponse;

        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botResponse = itemView.findViewById(R.id.botResponse);
        }
    }
}
