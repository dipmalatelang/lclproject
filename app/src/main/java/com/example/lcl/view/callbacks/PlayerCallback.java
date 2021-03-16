package com.example.lcl.view.callbacks;

import android.view.View;

import com.example.lcl.data.playerlist.PlayerData;

public interface PlayerCallback {
    void onPlayerClick(PlayerData data, View v, int position);
}
