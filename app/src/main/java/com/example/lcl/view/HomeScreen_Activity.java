package com.example.lcl.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lcl.R;
import com.example.lcl.databinding.ActivityHomeScreenBinding;
import com.example.lcl.view.login.LoginActivity;
import com.example.lcl.view.playerlist.PlayerListing;
import com.example.lcl.view.teamlist.TeamListActivity;

public class HomeScreen_Activity extends AppCompatActivity implements View.OnClickListener {
    ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);
        binding.teams.setOnClickListener(this);
        binding.players.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.teams) {
            Intent tIntent = new Intent(HomeScreen_Activity.this, TeamListActivity.class);
            startActivity(tIntent);
        }
        else {
            Intent pIntent = new Intent(HomeScreen_Activity.this, PlayerListing.class);
            startActivity(pIntent);


        }


    }
}