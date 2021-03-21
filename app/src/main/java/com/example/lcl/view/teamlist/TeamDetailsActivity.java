package com.example.lcl.view.teamlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.lcl.R;
import com.example.lcl.data.playerlist.PlayerData;
import com.example.lcl.data.teams.TeamData;
import com.example.lcl.databinding.ActivityTeamDetailsBinding;

public class TeamDetailsActivity extends AppCompatActivity {

    private ActivityTeamDetailsBinding binding;
    private TeamData teamData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_details);

        binding.tbTeamDetails.tvReportIssueTitle.setText(R.string.team_details_title);

        binding.tbTeamDetails.tvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        if(getIntent() != null){
            teamData = (TeamData) getIntent().getSerializableExtra("team_data");
            binding.setData(teamData);
        } else {
            binding.setData(null);
        }
    }
}