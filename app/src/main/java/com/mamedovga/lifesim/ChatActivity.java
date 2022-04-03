package com.mamedovga.lifesim;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mamedovga.lifesim.databinding.ChatBinding;
import com.mamedovga.lifesim.models.Chat;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ChatBinding binding;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<Chat> chatArrayList;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        chatArrayList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.chatRecyclerView.setLayoutManager(linearLayoutManager);
        binding.chatRecyclerView.setAdapter(chatAdapter);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editText.getText().toString().isEmpty()) {
                    Toast.makeText(ChatActivity.this, "Введите сообщение", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getResp(String message) {

    }
}