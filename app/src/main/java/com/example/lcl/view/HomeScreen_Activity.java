package com.example.lcl.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lcl.R;
import com.example.lcl.databinding.ActivityHomeScreenBinding;
import com.example.lcl.view.playerlist.PlayerListing;
import com.example.lcl.view.teamlist.TeamListActivity;

public class HomeScreen_Activity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);

        binding.players.setOnClickListener(this);
        binding.teams.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.players:
                switchActivity(PlayerListing.class);
                break;
            case R.id.teams:
                switchActivity(TeamListActivity.class);
                break;
        }
    }

    private void switchActivity(Class<?> cls) {
        startActivity(new Intent(HomeScreen_Activity.this, cls));
    }
}