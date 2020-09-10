package com.example.gadsleaderboardapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboardapp.R;
import com.example.gadsleaderboardapp.model.Hours;
import com.example.gadsleaderboardapp.network.HoursService;
import com.example.gadsleaderboardapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LearningLeadersFragment extends Fragment {

    Retrofit mRetrofit = new RetrofitClient().getmRetrofit();
    HoursService mHoursService = mRetrofit.create(HoursService.class);


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LearningLeadersFragment() {
    }


    public static LearningLeadersFragment newInstance(String param1, String param2) {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    public void getHours (){
        Call<List<Hours>> call = mHoursService.getHours();
        call.enqueue(new Callback<List<Hours>>() {
            @Override
            public void onResponse(Call<List<Hours>> call, Response<List<Hours>> response) {
                if(response.isSuccessful()){
                    List<Hours> listOfHours = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Hours>> call, Throwable t) {

            }
        });
    }
}