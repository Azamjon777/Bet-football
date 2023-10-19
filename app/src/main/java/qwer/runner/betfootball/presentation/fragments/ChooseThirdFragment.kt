package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import qwer.runner.betfootball.R
import qwer.runner.betfootball.adapter.TextListAdapter
import qwer.runner.betfootball.databinding.FragmentChooseThirdBinding
import qwer.runner.betfootball.viewmodel.ListViewModel
import qwer.runner.betfootball.viewmodel.ListViewModelFactory

class ChooseThirdFragment : Fragment(), TextListAdapter.ItemClickListener {

    private lateinit var binding: FragmentChooseThirdBinding
    private lateinit var thirdAdapter: TextListAdapter
    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        thirdAdapter = TextListAdapter(viewModel.listOfStyle, this)
        binding.styleRecyclerView.adapter = thirdAdapter
    }

    override fun onItemClick(item: String) {
        findNavController().navigate(R.id.action_chooseThirdFragment_to_thirdGameFragment)
    }
}

