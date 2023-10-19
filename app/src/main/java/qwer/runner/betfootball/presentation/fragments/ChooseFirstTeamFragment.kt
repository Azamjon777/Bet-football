package qwer.runner.betfootball.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import qwer.runner.betfootball.R
import qwer.runner.betfootball.adapter.TeamAdapter
import qwer.runner.betfootball.databinding.FragmentChooseFirstTeamBinding
import qwer.runner.betfootball.model.TeamModel
import qwer.runner.betfootball.viewmodel.ListViewModel
import qwer.runner.betfootball.viewmodel.ListViewModelFactory

class ChooseFirstTeamFragment : Fragment(), TeamAdapter.TeamClickListener {

    private lateinit var binding: FragmentChooseFirstTeamBinding
    private lateinit var teamAdapter: TeamAdapter
    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseFirstTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamAdapter = TeamAdapter(viewModel.teamList, this)

        binding.styleRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = teamAdapter
        }
    }

    override fun onTeamClick(team: TeamModel) {
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val sharedPreferencesEditor = sharedPreferences.edit()
        sharedPreferencesEditor.putString("team1", team.teamName)
        sharedPreferencesEditor.putString("team1Img", team.teamFlag)
        sharedPreferencesEditor.apply()

        findNavController().navigate(R.id.action_chooseFirstTeamFragment_to_chooseSecondTeamFragment)
    }
}
