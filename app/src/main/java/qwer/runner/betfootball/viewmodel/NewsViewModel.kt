package qwer.runner.betfootball.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import qwer.runner.betfootball.R
import qwer.runner.betfootball.model.NewsModel

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val _newsList = MutableLiveData<List<NewsModel>>()
    val newsList: LiveData<List<NewsModel>> = _newsList

    init {
        val dummyNewsList = listOf(
            NewsModel(
                application.getString(R.string.title1),
                application.getString(R.string.desc1)
            ),
            NewsModel(
                application.getString(R.string.title2),
                application.getString(R.string.desc2)
            ),
            NewsModel(
                application.getString(R.string.title3),
                application.getString(R.string.desc3)
            ),
            NewsModel(
                application.getString(R.string.title4),
                application.getString(R.string.desc4)
            ),
            NewsModel(
                application.getString(R.string.title5),
                application.getString(R.string.desc5)
            ),
            NewsModel(
                application.getString(R.string.title6),
                application.getString(R.string.desc6)
            ),
            NewsModel(
                application.getString(R.string.title7),
                application.getString(R.string.desc7)
            ),
            NewsModel(
                application.getString(R.string.title8),
                application.getString(R.string.desc8)
            ),
            NewsModel(
                application.getString(R.string.title9),
                application.getString(R.string.desc9)
            ),
            NewsModel(
                application.getString(R.string.title10),
                application.getString(R.string.desc10)
            ),
            NewsModel(
                application.getString(R.string.title11),
                application.getString(R.string.desc11)
            ),
            NewsModel(
                application.getString(R.string.title12),
                application.getString(R.string.desc12)
            ),
            NewsModel(
                application.getString(R.string.title13),
                application.getString(R.string.desc13)
            ),
            NewsModel(
                application.getString(R.string.title15),
                application.getString(R.string.desc15)
            )
        )
        _newsList.value = dummyNewsList
    }
}
