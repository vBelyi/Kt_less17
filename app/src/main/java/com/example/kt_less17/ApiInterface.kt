package com.example.kt_less17

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("/superhero-api/api/all.json")
    fun getRequest(): Observable<List<GetResponse>>
}