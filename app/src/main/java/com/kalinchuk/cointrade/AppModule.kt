package com.kalinchuk.cointrade

import android.content.Context
import com.kalinchuk.coin.database.CoinDatabase
import com.kalinchuk.coingeckoapi.CoinGeckoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi(): CoinGeckoApi {
        return CoinGeckoApi(
            apiKey = BuildConfig.API_KEY,
            baseUrl = BuildConfig.BASE_URL
        )
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CoinDatabase {
        return CoinDatabase(context)
    }
}