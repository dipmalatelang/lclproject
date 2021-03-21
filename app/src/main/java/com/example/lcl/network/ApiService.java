package com.example.lcl.network;

import com.example.lcl.data.DefaultResponse;
import com.example.lcl.data.login.LoginResponse;
import com.example.lcl.data.playerlist.PlayerListResponse;
import com.example.lcl.data.registerplayer.RegisterPlayerModel;
import com.example.lcl.data.teams.TeamListResponse;
import com.example.lcl.data.teams.TeamResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {

    @GET("TeamList")
    Call<TeamListResponse> getTeamList(@Query("teamId") String teamId);

    @GET("TeamList")
    Call<TeamResponse> getTeamResponseWithPlayers(@Query("teamId") String teamId);

    @GET("PlayerList")
    Call<PlayerListResponse> getPlayerList(@Query("playerId") String playerId);

    @POST("RegisterPlayer")
    Call<DefaultResponse> registerPlayer(@Body RegisterPlayerModel model);

    @GET("UpdateTeamPlayer")
    Call<DefaultResponse> updatePlayer(
            @Query("playerId") String playerId,
            @Query("teamId") String teamId,
            @Query("soldPrice") long soldPrice);

    @GET("Login")
    Call<LoginResponse> attemptLogin(
            @Query("userId") String userId,
            @Query("password") String password
    );

}
