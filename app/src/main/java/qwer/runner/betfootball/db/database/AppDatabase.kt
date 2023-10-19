package qwer.runner.betfootball.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import qwer.runner.betfootball.db.dao.MatchDao
import qwer.runner.betfootball.model.MatchEntity

@Database(entities = [MatchEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
}
