package me.linshen.retrofit2.adapter.livedata.demo.api

import androidx.lifecycle.LiveData
import me.linshen.retrofit2.adapter.ApiResponse
import me.linshen.retrofit2.adapter.livedata.demo.vo.UserVO
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{login}")
    fun getUser(@Path("login") login: String): LiveData<ApiResponse<UserVO>>

}