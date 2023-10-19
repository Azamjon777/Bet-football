package qwer.runner.betfootball.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import qwer.runner.betfootball.R
import qwer.runner.betfootball.adapter.TeamAdapter
import qwer.runner.betfootball.databinding.FragmentChooseSecondTeamBinding
import qwer.runner.betfootball.model.TeamModel
import qwer.runner.betfootball.viewmodel.ListViewModel
import qwer.runner.betfootball.viewmodel.ListViewModelFactory

class ChooseSecondTeamFragment : Fragment(), TeamAdapter.TeamClickListener {

    private lateinit var binding: FragmentChooseSecondTeamBinding
    private lateinit var teamAdapter: TeamAdapter

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseSecondTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamAdapter = TeamAdapter(viewModel.teamList, this)
        binding.secondTeamRecyclerView.adapter = teamAdapter
    }

    override fun onTeamClick(team: TeamModel) {
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedTeam2 = sharedPreferences.getString("team2", null)

        if (team.teamName != savedTeam2) {
            val sharedPreferencesEditor = sharedPreferences.edit()
            sharedPreferencesEditor.putString("team2", team.teamName)
            sharedPreferencesEditor.putString("team2Img", team.teamFlag)
            sharedPreferencesEditor.apply()

            findNavController().navigate(R.id.action_chooseSecondTeamFragment_to_chooseThirdFragment)
        } else {
            Toast.makeText(
                requireActivity(),
                getString(R.string.choose_another_team),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
