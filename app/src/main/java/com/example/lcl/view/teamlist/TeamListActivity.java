package com.example.lcl.view.teamlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lcl.R;
import com.example.lcl.data.TeamListResponse;
import com.example.lcl.network.ApiClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamListActivity extends AppCompatActivity {

    private static final String TAG = "TeamListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        performServerCallToFetchTeamList("M1");
    }

    private void performServerCallToFetchTeamList(String teamId){
        ApiClient.create().getTeamList(teamId)
                .enqueue(teamCallback);
    }

    private final Callback<TeamListResponse> teamCallback = new Callback<TeamListResponse>() {
        @Override
        public void onResponse(@NotNull Call<TeamListResponse> call, Response<TeamListResponse> response) {
            if (response.isSuccessful()) {
                Toast.makeText(TeamListActivity.this, response.body().getData().get(0).getTeamName(), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, "onResponse: something went wrong");
            }
        }

        @Override
        public void onFailure(@NotNull Call<TeamListResponse> call, Throwable t) {
            Log.e(TAG, "onFailure: " + t.getMessage());
        }
    };
}