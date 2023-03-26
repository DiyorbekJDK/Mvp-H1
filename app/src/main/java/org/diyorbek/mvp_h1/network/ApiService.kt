package org.diyorbek.mvp_h1.network

import org.diyorbek.mvp_h1.model.Data
import org.diyorbek.mvp_h1.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getAllUsers(): Call<List<Data>>
}