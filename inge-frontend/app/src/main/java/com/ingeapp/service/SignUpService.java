package com.ingeapp.service;

import com.ingeapp.model.request.SignUpRequest;
import com.ingeapp.service.payload.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpService {
    @POST("/signup")
    Call<UserResponse> signUp(@Body SignUpRequest body);
}
