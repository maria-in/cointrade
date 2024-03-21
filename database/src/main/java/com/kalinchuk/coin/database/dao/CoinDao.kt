package com.kalinchuk.coin.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kalinchuk.coin.database.models.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin_list")
    fun getCoinsList(): Flow<List<CoinEntity>>

    @Insert
    suspend fun insertAllCoins(coins: List<CoinEntity>)

    @Delete
    suspend fun removeAllCoins(coins: List<CoinEntity>)

    @Query("DELETE FROM coin_list")
    suspend fun clearAllCoins()
}