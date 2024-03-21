package com.kalinchuk.coin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kalinchuk.coin.database.dao.CoinDao
import com.kalinchuk.coin.database.models.CoinEntity
import com.kalinchuk.coin.database.utils.Converters

class CoinDatabase internal constructor(private val database: RoomCoinDatabase) {
    val coinDao: CoinDao
        get() = database.coinDao()
}

@Database(entities = [CoinEntity::class], version = 1)
@TypeConverters(Converters::class)
internal abstract class RoomCoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}

fun CoinDatabase(applicationContext: Context): CoinDatabase {
    val coinRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        RoomCoinDatabase::class.java,
        "coins-db"
    ).build()
    return CoinDatabase(coinRoomDatabase)
}