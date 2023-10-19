package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import qwer.runner.betfootball.databinding.FragmentTacticsDescBinding
import qwer.runner.betfootball.model.TacticsModel

class TacticsDescFragment : Fragment() {

    private var _binding: FragmentTacticsDescBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTacticsDescBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getSerializable("tacticsModel") as? TacticsModel

        if (item != null) {
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.desc
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}