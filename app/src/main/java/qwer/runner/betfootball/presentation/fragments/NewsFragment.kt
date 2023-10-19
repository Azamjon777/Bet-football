package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import qwer.runner.betfootball.adapter.NewsAdapter
import qwer.runner.betfootball.databinding.FragmentNewsBinding
import qwer.runner.betfootball.viewmodel.NewsViewModel
import qwer.runner.betfootball.viewmodel.NewsViewModelFactory

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(activity).application
        val viewModelFactory = NewsViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]

        adapter = NewsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.newsList.observe(viewLifecycleOwner) { newsList ->
            adapter.newsList = newsList
            adapter.notifyDataSetChanged()
        }
    }
}