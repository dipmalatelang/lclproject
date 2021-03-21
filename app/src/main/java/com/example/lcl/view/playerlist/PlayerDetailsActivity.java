package com.example.lcl.view.playerlist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.lcl.R;
import com.example.lcl.data.DefaultResponse;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.databinding.ActivityPlayerDetailsBinding;
import com.example.lcl.network.ApiClient;
import com.example.lcl.util.SharedPref;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerDetailsActivity extends AppCompatActivity {

    private ActivityPlayerDetailsBinding binding;
    private PlayerData playerData;
    private static final String TAG = "PlayerDetailsActivity";
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_details);

        sharedPref = SharedPref.getInstance();
        binding.pbPlayerDetails.hide();

        binding.tbPlayerDetails.tvTitle.setText(getString(R.string.player_details_title));

        binding.tbPlayerDetails.tvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        if (getIntent() != null) {
            playerData = (PlayerData) getIntent().getSerializableExtra("player_data");
            binding.setData(playerData);
        } else {
            binding.setData(null);
        }

        boolean isSuperUser = false;

        if (sharedPref.containsKey("user_role")) {
            isSuperUser = sharedPref.getString("user_role", "").equalsIgnoreCase("super") &&
                    playerData.getSoldPrice().equalsIgnoreCase("No Data available");
        }
        binding.btnBuyPlayer.setVisibility(isSuperUser ? View.VISIBLE : View.INVISIBLE);
        binding.btnBuyPlayer.setOnClickListener(v -> getSoldValue(this));
    }

    private void performServerCallToUpdatePlayer(String teamId, long soldPrice) {
        binding.pbPlayerDetails.show();
        ApiClient.create().updatePlayer(playerData.getPlayerNumber(), teamId, soldPrice)
                .enqueue(playerListCallback);
    }

    private final Callback<DefaultResponse> playerListCallback = new Callback<DefaultResponse>() {
        @Override
        public void onResponse(@NotNull Call<DefaultResponse> call, Response<DefaultResponse> response) {
            binding.pbPlayerDetails.hide();
            if (response.isSuccessful()) {
                if (response.body().getStatus()) {
                    Toast.makeText(PlayerDetailsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                } else if (!response.body().getStatus()) {
                    Toast.makeText(PlayerDetailsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PlayerDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<DefaultResponse> call, Throwable t) {
            binding.pbPlayerDetails.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };

    private void getSoldValue(Context context) {

        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_buy_dialog, null, false);

        TextInputEditText team = dialogView.findViewById(R.id.et_player_team);
        TextInputEditText soldPrice = dialogView.findViewById(R.id.et_player_sold_price);

        dialogBuilder.setView(dialogView)
                .setTitle(getString(R.string.buy_title))
                .setPositiveButton(getString(R.string.buy), (dialog, which) -> {
                    String teamName = team.getText().toString();
                    String soldAmount = soldPrice.getText().toString();
                    if (!teamName.isEmpty() && !soldAmount.isEmpty()) {
                        showConfirmDialog(teamName, soldAmount);
                    } else {
                        Toast.makeText(context, "Please enter all details", Toast.LENGTH_SHORT).show();
                    }
                    dialog.dismiss();
                })
                .setNegativeButton(android.R.string.cancel, (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    private void showConfirmDialog(String teamName, String soldAmount){
        new MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.confirm_dialog_title))
                .setMessage("Are you sure you want to buy this player at " + soldAmount + ", for team " + teamName)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    performServerCallToUpdatePlayer(teamName.toUpperCase(), Long.parseLong(soldAmount));
                    dialog.dismiss();
                })
                .setNegativeButton(android.R.string.cancel, (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }
}