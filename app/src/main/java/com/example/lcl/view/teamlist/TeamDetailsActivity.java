package com.example.lcl.view.teamlist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.lcl.R;
import com.example.lcl.data.teams.TeamData;
import com.example.lcl.data.teams.TeamResponse;
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
            binding.setTeamData(teamData);
            performServerCallToFetchTeamList(teamData.getTeamNumber());
        } else {
            binding.setData(null);
        }

        performServerCallToFetchTeamList(teamData.getTeamNumber());
    }

    private void performServerCallToFetchTeamList(String teamId){
        binding.pbPlayerDetailsList.show();
        ApiClient.create().getTeamResponseWithPlayers(teamId)
                .enqueue(teamDetailsCallback);
    }

    private final Callback<TeamResponse> teamDetailsCallback = new Callback<TeamResponse>() {
        @Override
        public void onResponse(@NotNull Call<TeamResponse> call, Response<TeamResponse> response) {
            binding.pbPlayerDetailsList.hide();
            if (response.isSuccessful()) {
                if(response.body().getStatus()){
                    if(response.body().getResPlayers().size() > 0 && response.body().getResPlayers() != null){
                        binding.setData(response.body().getResPlayers());
                        binding.setCallback((dataType, view, position) -> {
                            Log.d(TAG, "onResponse: clicked" + position);
                        });
                        binding.tvNoData.setVisibility(View.GONE);
                    } else {
                        binding.rvPlayerList.setVisibility(View.GONE);
                        binding.tvNoData.setVisibility(View.VISIBLE);
                    }
                }
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<TeamResponse> call, Throwable t) {
            binding.pbPlayerDetailsList.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}