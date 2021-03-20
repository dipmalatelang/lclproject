package com.example.lcl.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lcl.R;
import com.example.lcl.generated.callback.OnClickListener;
import com.example.lcl.view.playerlist.PlayerListing;
import com.example.lcl.view.teamlist.TeamListActivity;

public class HomeScreen_Activity extends AppCompatActivity {

    private CardView platersCardview, teamsCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        platersCardview = findViewById(R.id.players);
        teamsCardview = findViewById(R.id.teams);

        platersCardview.setOnClickListener(v -> {
            Intent mIntent = new Intent(HomeScreen_Activity.this, PlayerListing.class);
            startActivity(mIntent);
        });

        teamsCardview.setOnClickListener(v -> {
            Intent mIntent = new Intent(HomeScreen_Activity.this, TeamListActivity.class);
            startActivity(mIntent);
        });
    }
}