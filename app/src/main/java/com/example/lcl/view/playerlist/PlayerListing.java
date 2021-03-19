package com.example.lcl.view.playerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.data.playerlist.PlayerListResponse;
import com.example.lcl.databinding.ActivityPlayerListingBinding;
import com.example.lcl.network.ApiClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerListing extends AppCompatActivity {
    private ActivityPlayerListingBinding binding;
    private static final String TAG = "PlayerListing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_listing);
        performServerCallToGetPlayers();
    }

    private void performServerCallToGetPlayers(){
        binding.pbPlayerList.show();
        ApiClient.create().getPlayerList("")
                .enqueue(playerListCallback);
    }

    private final Callback<PlayerListResponse> playerListCallback = new Callback<PlayerListResponse>() {
        @Override
        public void onResponse(@NotNull Call<PlayerListResponse> call, Response<PlayerListResponse> response) {
            binding.pbPlayerList.hide();
            if (response.isSuccessful()) {
                if(response.body().getStatus()){
                    binding.setData(response.body().getData());
                    binding.setCallback((dataType, view, position) -> {
                        Toast.makeText(PlayerListing.this, "clicked " + ((PlayerData) dataType).getFirstName(), Toast.LENGTH_LONG).show();
                    });
                }
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<PlayerListResponse> call, Throwable t) {
            binding.pbPlayerList.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}