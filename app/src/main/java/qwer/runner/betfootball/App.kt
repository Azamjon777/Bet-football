package qwer.runner.betfootball

import android.app.Application
import androidx.room.Room
import qwer.runner.betfootball.db.database.AppDatabase

class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()
    }
}
