package com.mamedovga.lifesim;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mamedovga.lifesim.databinding.ChatBinding;
import com.mamedovga.lifesim.models.Chat;
import com.mamedovga.lifesim.models.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                    return;
                }
                getResp(binding.editText.getText().toString());
                binding.editText.setText("");
            }
        });
    }

    private void getResp(String message) {
        chatArrayList.add(new Chat(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=165288&key=kUfecpVDbDxJUmDV&uid=[uid]&msg=" + message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<Response> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()) {
                    Response response1 = response.body();
                    chatArrayList.add(new Chat(response1.getResponse(), BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                chatArrayList.add(new Chat("Повтори сообщение, до меня не дошло", BOT_KEY));
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
}