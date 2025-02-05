package com.example.openinapp.api

import com.example.openinapp.model.LinksResponse
import com.example.openinapp.network.NetworkResult
import retrofit2.Response
import retrofit2.http.GET

interface LinksAPI {
    @GET("/api/v1/dashboardNew")
    suspend fun getLinksData() : Response<LinksResponse>
}