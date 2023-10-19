package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import qwer.runner.betfootball.R
import qwer.runner.betfootball.adapter.TacticsAdapter
import qwer.runner.betfootball.databinding.FragmentTacticsBinding
import qwer.runner.betfootball.model.TacticsModel

class TacticsFragment : Fragment(R.layout.fragment_tactics), TacticsAdapter.OnItemClickListener {

    private lateinit var binding: FragmentTacticsBinding
    private lateinit var tacticsAdapter: TacticsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTacticsBinding.bind(view)

        val tacticsList = listOf(
            TacticsModel(
                getString(R.string.attacking_against_a_zone_defence),
                getString(R.string.tatcics_desc1)
            ),
            TacticsModel(getString(R.string.positional_attack), getString(R.string.tatcics_desc2)),
            TacticsModel(
                getString(R.string.counter_attack_fast_break),
                getString(R.string.tatcics_desc3)
            ),
            TacticsModel(getString(R.string.pressing_defence), getString(R.string.tatcics_desc4)),
            TacticsModel(getString(R.string.mixed_defence), getString(R.string.tatcics_desc5)),
            TacticsModel(getString(R.string.zone_defence), getString(R.string.tatcics_desc6)),
            TacticsModel(
                getString(R.string.defence_against_the_ball_carrier),
                getString(R.string.tatcics_desc7)
            )
        )

        tacticsAdapter = TacticsAdapter(tacticsList, this)
        binding.tacticsRecyclerView.adapter = tacticsAdapter
    }

    override fun onItemClick(tacticsModel: TacticsModel) {
        val bundle = Bundle().apply {
            putSerializable("tacticsModel", tacticsModel)
        }

        findNavController().navigate(
            R.id.action_tacticsFragment_to_tacticsDescFragment,
            bundle
        )
    }
}