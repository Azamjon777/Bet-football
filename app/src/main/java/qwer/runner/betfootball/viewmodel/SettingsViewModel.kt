package qwer.runner.betfootball.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel(private val context: Context) : ViewModel() {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    private val _soundProgress = MutableLiveData<Int>()
    private val _vibrationProgress = MutableLiveData<Int>()
    private val _brightnessProgress = MutableLiveData<Int>()

    val soundProgress: LiveData<Int> = _soundProgress
    val vibrationProgress: LiveData<Int> = _vibrationProgress
    val brightnessProgress: LiveData<Int> = _brightnessProgress

    init {
        _soundProgress.value = getSavedProgress("sound_progress")
        _vibrationProgress.value = getSavedProgress("vibration_progress")
        _brightnessProgress.value = getSavedProgress("brightness_progress")
    }

    fun setSoundProgress(progress: Int) {
        _soundProgress.value = progress
        saveProgress("sound_progress", progress)
    }

    fun setVibrationProgress(progress: Int) {
        _vibrationProgress.value = progress
        saveProgress("vibration_progress", progress)
    }

    fun setBrightnessProgress(progress: Int) {
        _brightnessProgress.value = progress
        saveProgress("brightness_progress", progress)
    }

    private fun saveProgress(key: String, progress: Int) {
        sharedPreferences.edit().putInt(key, progress).apply()
    }

    private fun getSavedProgress(key: String): Int {
        return sharedPreferences.getInt(key, 0) // 0 - значение по умолчанию
    }
}
