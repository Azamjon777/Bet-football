package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.runBlocking
import qwer.runner.betfootball.App.Companion.appDatabase
import qwer.runner.betfootball.adapter.FinishedMatchesAdapter
import qwer.runner.betfootball.databinding.FragmentFinishedMatchesBinding
import qwer.runner.betfootball.model.MatchEntity

class FinishedMatchesFragment : Fragment() {

    private lateinit var binding: FragmentFinishedMatchesBinding
    private lateinit var adapter: FinishedMatchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFinishedMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FinishedMatchesAdapter(loadMatchResults())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadMatchResults(): List<MatchEntity> {
        val matchDao = appDatabase.matchDao()
        return runBlocking {
            matchDao.getAllMatches()
        }
    }

}
