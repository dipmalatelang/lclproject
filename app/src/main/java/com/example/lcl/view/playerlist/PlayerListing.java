package com.example.lcl.view.playerlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.lcl.R;
import com.example.lcl.databinding.ActivityPlayerListingBinding;

public class PlayerListing extends AppCompatActivity {
    private ActivityPlayerListingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_listing);
    }
}