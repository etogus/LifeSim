package com.mamedovga.lifesim;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
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
                //sendMessage(binding.editText.getText().toString());
                binding.editText.setText("");
            }
        });
    }

    private void getResp(String message) {
        chatArrayList.add(new Chat(message, USER_KEY));
        chatAdapter.notifyDataSetChanged();
        //String url = "http://api.brainshop.ai/get?bid=165288&key=kUfecpVDbDxJUmDV&uid=[uid]&msg=" + message;
        String BASE_URL = "http://127.0.0.1:5000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<Response> call = retrofitAPI.sendMessage(message);
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

    private void sendMessage(String userMsg) {
        // below line is to pass message to our
        // array list which is entered by the user.
        chatArrayList.add(new Chat(userMsg, USER_KEY));
        chatAdapter.notifyDataSetChanged();

        // url for our brain
        // make sure to add mshape for uid.
        // make sure to add your url.
        String url = "http://api.brainshop.ai/get?bid=165288&key=kUfecpVDbDxJUmDV&uid=[uid]&msg=" + userMsg;

        // creating a variable for our request queue.
        RequestQueue queue = Volley.newRequestQueue(ChatActivity.this);

        // on below line we are making a json object request for a get request and passing our url .
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // in on response method we are extracting data
                    // from json response and adding this response to our array list.
                    String botResponse = response.getString("cnt");
                    chatArrayList.add(new Chat(botResponse, BOT_KEY));

                    // notifying our adapter as data changed.
                    chatAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();

                    // handling error response from bot.
                    chatArrayList.add(new Chat("No response", BOT_KEY));
                    chatAdapter.notifyDataSetChanged();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // error handling.
                chatArrayList.add(new Chat("Sorry no response found", BOT_KEY));
                Toast.makeText(ChatActivity.this, "No response from the bot..", Toast.LENGTH_SHORT).show();
            }
        });
        // at last adding json object
        // request to our queue.
        queue.add(jsonObjectRequest);
    }
}