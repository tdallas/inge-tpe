package com.ingeapp.service;

import com.ingeapp.model.request.LoginRequest;
import com.ingeapp.service.payload.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/login")
    Call<UserResponse> login(@Body LoginRequest body);
}
