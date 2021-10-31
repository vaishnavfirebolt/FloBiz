package com.vaishnav.flobiz.data.network

import com.vaishnav.flobiz.model.RemoteResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&order=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestions(): RemoteResponse
}