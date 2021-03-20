package com.example.lcl.view.playerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.databinding.ActivityPlayerDetailsBinding;

public class PlayerDetailsActivity extends AppCompatActivity {

    private ActivityPlayerDetailsBinding binding;
    private PlayerData playerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_details);

        binding.tbPlayerDetails.tvReportIssueTitle.setText(getString(R.string.player_details_title));

        binding.tbPlayerDetails.tvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        if(getIntent() != null){
            playerData = (PlayerData)getIntent().getSerializableExtra("player_data");
            binding.setData(playerData);
        } else {
            binding.setData(null);
        }
    }
}