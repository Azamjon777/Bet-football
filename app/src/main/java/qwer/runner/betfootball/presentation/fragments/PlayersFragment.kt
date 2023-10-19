package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import qwer.runner.betfootball.adapter.PlayersAdapter
import qwer.runner.betfootball.databinding.FragmentPlayersBinding

class PlayersFragment : Fragment() {

    private lateinit var binding: FragmentPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater, container, false)

        val playersRecyclerView = binding.playersRecyclerView

        val args: PlayersFragmentArgs by navArgs()
        val players = args.Team.players

        val adapter = PlayersAdapter(players)
        playersRecyclerView.adapter = adapter
        playersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }
}
