package com.example.gadsleaderboardapp.network;

import com.example.gadsleaderboardapp.model.Hours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoursService {
    @GET("api/hours/")
    Call<List<Hours>> getHours();
}
