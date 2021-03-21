package com.example.lcl.view.teamlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.data.teams.TeamData;
import com.example.lcl.data.teams.TeamListResponse;
import com.example.lcl.databinding.ActivityTeamListBinding;
import com.example.lcl.network.ApiClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamListActivity extends AppCompatActivity {

    private static final String TAG = "TeamListActivity";
    private ActivityTeamListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_list);
        binding.pbTeamList.hide();

        binding.tbTeamList.tvTitle.setText(getString(R.string.team_title));
        binding.tbTeamList.tvBack.setOnClickListener(v -> onBackPressed());
        performServerCallToFetchTeamList("");
    }

    private void performServerCallToFetchTeamList(String teamId){
        binding.pbTeamList.show();
        ApiClient.create().getTeamList(teamId)
                .enqueue(teamCallback);
    }

    private final Callback<TeamListResponse> teamCallback = new Callback<TeamListResponse>() {
        @Override
        public void onResponse(@NotNull Call<TeamListResponse> call, Response<TeamListResponse> response) {
            binding.pbTeamList.hide();
            if (response.isSuccessful()) {
                if(response.body().getStatus()){
                    binding.setData(response.body().getData());
                    binding.setCallback((dataType, view, position) -> {
                        Toast.makeText(TeamListActivity.this, ((TeamData) dataType).getTeamName(), Toast.LENGTH_SHORT).show();
                    });
                }
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<TeamListResponse> call, Throwable t) {
            binding.pbTeamList.hide();
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}