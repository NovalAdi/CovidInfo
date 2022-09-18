package com.vall.covidinfo.service

import com.vall.covidinfo.model.CountriesItem
import com.vall.covidinfo.model.ResponseCovid
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

object APIService {

    private val client : OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(15,TimeUnit.SECONDS)
        .readTimeout(10,TimeUnit.SECONDS)
        .writeTimeout(10,TimeUnit.SECONDS)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServiceCovid() = retrofit.create(covidCountry::class.java)
    fun getServiceInfoCovid() = retrofit.create(InfoService::class.java)
}
interface covidCountry {
    @GET ("summary")

    fun getAllNegara() : Call<ResponseCovid>
}
interface InfoService {
    @GET
    fun getInfoSerivce(@Url url: String?) : Call<List<CountriesItem>>
}