package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import qwer.runner.betfootball.R
import qwer.runner.betfootball.adapter.TeamsListAdapter
import qwer.runner.betfootball.model.TeamModel
import qwer.runner.betfootball.viewmodel.ListViewModel
import qwer.runner.betfootball.viewmodel.ListViewModelFactory

class TeamsFragment : Fragment(), TeamsListAdapter.OnTeamClickListener {
    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_teams, container, false)

        val teamsRecyclerView: RecyclerView = view.findViewById(R.id.teamsRecyclerView)

        val adapter = TeamsListAdapter(viewModel.teamList, this)

        teamsRecyclerView.adapter = adapter
        teamsRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onTeamClick(team: TeamModel) {
        val action = TeamsFragmentDirections.actionTeamsFragmentToPlayersFragment(team)
        findNavController().navigate(action)
    }
}
