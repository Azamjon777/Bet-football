package qwer.runner.betfootball.model

import java.io.Serializable

class TeamModel(
    val teamFlag: String,
    val teamName: String,
    val players:List<String>
):Serializable