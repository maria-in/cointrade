package com.kalinchuk.coingeckoapi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kalinchuk.coingeckoapi.utils.CoinGeckoApiInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * [API Documentation](https://docs.coingecko.com/v3.0.1/reference/endpoint-overview)
 */
interface CoinGeckoApi {

    /**
     * Initial check after set up
     * API details [here](https://docs.coingecko.com/v3.0.1/reference/ping-server)
     */
    @GET("/ping")
    suspend fun checkServerStatus(): Result<Unit>
}

fun CoinGeckoApi(
    apiKey: String,
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
): CoinGeckoApi {
    return retrofit(apiKey, baseUrl, okHttpClient).create(CoinGeckoApi::class.java)
}

private fun retrofit(
    apiKey: String,
    baseUrl: String,
    okHttpClient: OkHttpClient?,
): Retrofit {
    val contentType = MediaType.get("application/json")

    val client: OkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(CoinGeckoApiInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .client(client)
        .build()
}