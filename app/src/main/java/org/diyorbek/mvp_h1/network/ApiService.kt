package org.diyorbek.mvp_h1.network

import org.diyorbek.mvp_h1.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-type:application/json")

    @GET("users")
    fun getAllUsers(): Call<List<Data>>
}