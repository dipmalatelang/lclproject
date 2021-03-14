package com.example.lcl.network;

import com.example.lcl.data.TeamListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("TeamList")
    Call<TeamListResponse> getTeamList(@Query("teamId") String teamId);
}
