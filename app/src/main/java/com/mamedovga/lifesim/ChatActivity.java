package com.mamedovga.lifesim;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mamedovga.lifesim.databinding.ChatBinding;
import com.mamedovga.lifesim.models.Chat;
import com.mamedovga.lifesim.models.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ChatActivity extends AppCompatActivity {
    private ChatBinding binding;
    private static final String TAG = "ChatActivity";
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
                //sendMessage(binding.editText.getText().toString());
                binding.editText.setText("");
            }
        });
    }

    private void getResp(String message) {
        chatArrayList.add(new Chat(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        RetrofitAPI retrofitAPI = RetrofitClient.getRetrofitInstance().create(RetrofitAPI.class);
        Call<Response> call = retrofitAPI.sendMessage(message);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                //if(response.isSuccessful()) {
                    Response response1 = response.body();
                    chatArrayList.add(new Chat(response1.getResponse(), BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                    Log.e(TAG, "onResponse: " + response.body());
                //}
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                chatArrayList.add(new Chat("Повтори сообщение, до меня не дошло", BOT_KEY));
                chatAdapter.notifyDataSetChanged();
            }
        });
    }

    private void sendMessage(String userMsg) {
        chatArrayList.add(new Chat(userMsg, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("chatInput", userMsg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = "http://192.168.1.55:5000/chat";
        RequestQueue queue = Volley.newRequestQueue(ChatActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String botResponse = response.getString("chatBotReply");
                    chatArrayList.add(new Chat(botResponse, BOT_KEY));

                    chatAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();

                    chatArrayList.add(new Chat("No response", BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                chatArrayList.add(new Chat("Sorry no response found", BOT_KEY));
                Toast.makeText(ChatActivity.this, "No response from the bot..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}