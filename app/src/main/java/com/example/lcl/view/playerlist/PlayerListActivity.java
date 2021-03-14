package com.example.lcl.view.playerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerListResponse;
import com.example.lcl.data.teams.TeamListResponse;
import com.example.lcl.databinding.ActivityPlayerListBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.view.teamlist.TeamListActivity;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerListActivity extends AppCompatActivity {
    private static final String TAG = "PlayerListActivity";
    private ActivityPlayerListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_list);

        performServerCallToFetchPlayerList("M1");
    }

    private void performServerCallToFetchPlayerList(String playerId){
        ApiClient.create().getPlayerList(playerId)
                .enqueue(playerCallback);
    }

    private final Callback<PlayerListResponse> playerCallback = new Callback<PlayerListResponse>() {
        @Override
        public void onResponse(@NotNull Call<PlayerListResponse> call, Response<PlayerListResponse> response) {
            if (response.isSuccessful()) {
                Toast.makeText(PlayerListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<PlayerListResponse> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}