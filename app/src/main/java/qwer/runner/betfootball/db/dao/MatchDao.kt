package qwer.runner.betfootball.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import qwer.runner.betfootball.model.MatchEntity

@Dao
interface MatchDao {
    @Insert
    suspend fun insertMatch(match: MatchEntity)

    @Query("SELECT * FROM matches")
    suspend fun getAllMatches(): List<MatchEntity>
}
