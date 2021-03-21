package com.example.lcl.view.teamlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.data.teams.TeamData;
import com.example.lcl.data.teams.TeamListResponse;
import com.example.lcl.databinding.ActivityTeamDetailsBinding;
import com.example.lcl.network.ApiClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailsActivity extends AppCompatActivity {

    private ActivityTeamDetailsBinding binding;
    private TeamData teamData;
    private static final String TAG = "TeamDetailsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_details);

        binding.pbPlayerDetailsList.hide();

        binding.tbTeamDetails.tvTitle.setText(R.string.team_details_title);

        binding.tbTeamDetails.tvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        if(getIntent() != null){
            teamData = (TeamData) getIntent().getSerializableExtra("team_data");
            binding.setData(teamData);
        } else {
            binding.setData(null);
        }

        performServerCallToFetchTeamList(teamData.getTeamNumber());
    }

    private void performServerCallToFetchTeamList(String teamId){
        binding.pbPlayerDetailsList.show();
        ApiClient.create().getTeamList(teamId)
                .enqueue(teamCallback);
    }

    private final Callback<TeamListResponse> teamCallback = new Callback<TeamListResponse>() {
        @Override
        public void onResponse(@NotNull Call<TeamListResponse> call, Response<TeamListResponse> response) {
            binding.pbPlayerDetailsList.hide();
            if (response.isSuccessful()) {
                if(response.body().getStatus()){
                    binding.setListData(response.body().getResPlayers());
                    binding.setCallback((dataType, view, position) -> {
                        Log.d(TAG, "onResponse: clicked" + position);
                    });
                }
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<TeamListResponse> call, Throwable t) {
            binding.pbPlayerDetailsList.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}