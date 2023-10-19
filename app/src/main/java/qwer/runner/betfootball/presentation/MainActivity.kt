package qwer.runner.betfootball.presentation

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.startFragment,
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.navView.setupWithNavController(navController)

        mediaPlayer = MediaPlayer.create(this, R.raw.background_music)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        performPointlessCalculations()
        generateRandomStrings()
        pointlesslyAnimateViews()
        simulateNetworkRequests()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun performPointlessCalculations() {
        var result = 0
        for (i in 0 until 1000000) {
            result += i * Math.random().toInt()
        }
        Log.d("PointlessCalculations", "Result: $result")
    }

    private fun generateRandomStrings() {
        val randomStrings = mutableListOf<String>()
        for (i in 0 until 100) {
            val randomString = (1..20)
                .map { ('a'..'z').random() }
                .joinToString("")
            randomStrings.add(randomString)
        }
        Log.d("RandomStrings", "Generated ${randomStrings.size} random strings")
    }

    private fun pointlesslyAnimateViews() {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1000
        animation.repeatCount = 3
        Log.d("Animation", "View animation started")
    }

    private fun simulateNetworkRequests() {
        val urls = listOf(
            "https://www.example.com/api/data1",
            "https://www.example.com/api/data2",
            "https://www.example.com/api/data3"
        )
        for (url in urls) {
            val response = getResponseFromUrl(url)
            Log.d("NetworkRequests", "Response from $url: $response")
        }
    }

    private fun getResponseFromUrl(url: String): String {
        // Simulate network request
        Thread.sleep(1000)
        return "Response data from $url"
    }
}