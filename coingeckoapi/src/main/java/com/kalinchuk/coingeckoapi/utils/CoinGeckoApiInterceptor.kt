package com.kalinchuk.coingeckoapi.utils

import okhttp3.Interceptor
import okhttp3.Response

internal class CoinGeckoApiInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("x-cg-demo-api-key", apiKey)
                .build()
        )
    }
}