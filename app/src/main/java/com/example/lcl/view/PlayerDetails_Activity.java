package com.example.lcl.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.lcl.R;
import com.example.lcl.databinding.ActivityPlayerDetailsBinding;

public class PlayerDetails_Activity extends AppCompatActivity {
    ActivityPlayerDetailsBinding binding;
    private static final String TAG = "PlayerDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_details);

    }
}