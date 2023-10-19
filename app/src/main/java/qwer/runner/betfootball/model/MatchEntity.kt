package qwer.runner.betfootball.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val team1Name: String,
    val team2Name: String,
    val team1Img: String,
    val team2Img: String,
    val team1Score: String,
    val team2Score: String
)
