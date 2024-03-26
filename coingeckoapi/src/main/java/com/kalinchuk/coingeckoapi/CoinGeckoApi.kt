package com.kalinchuk.coingeckoapi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kalinchuk.coingeckoapi.models.CoinDTO
import com.kalinchuk.coingeckoapi.models.PingResponse
import com.kalinchuk.coingeckoapi.utils.CoinGeckoApiInterceptor
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [API Documentation](https://docs.coingecko.com/v3.0.1/reference/endpoint-overview)
 */
interface CoinGeckoApi {

    /**
     * Initial check after set up
     * API details [here](https://docs.coingecko.com/v3.0.1/reference/ping-server)
     */
    @GET("/ping")
    suspend fun checkServerStatus(): PingResponse

    /**
     * API details [here](https://docs.coingecko.com/v3.0.1/reference/coins-list)
     */
    @GET("/markets")
    suspend fun getCoinsList(
        @Query("vs_currency") currency: String = "usd",
        @Query("ids") ids: String? = null,
        @Query("category") category: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean? = null,
        @Query("price_change_percentage") priceChangePercentage: String? = null,
        @Query("locale") locale: String? = null,
        @Query("precision") precision: String? = null
    ): Result<Response<List<CoinDTO>>>
}

fun CoinGeckoApi(
    apiKey: String,
    baseUrl: String
): CoinGeckoApi {
    return retrofit(apiKey, baseUrl).create()
}

private fun retrofit(
    apiKey: String,
    baseUrl: String
): Retrofit {
    val contentType = "application/json".toMediaType()

    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(CoinGeckoApiInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory(contentType))
        //.addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(client)
        .build()
}