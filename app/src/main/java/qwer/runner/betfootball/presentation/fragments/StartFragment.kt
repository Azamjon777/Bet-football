package qwer.runner.betfootball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.FragmentStartBinding
import qwer.runner.betfootball.databinding.HowToPlayDialogBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_settingsFragment)
        }
        binding.btnHowToPlay.setOnClickListener {
            showHowToPlayDialog()
        }
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_chooseFirstTeamFragment)
        }
        binding.btnMyBets.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_finishedMatchesFragment)
        }
        binding.btnNews.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_newsFragment)
        }
    }

    private fun showHowToPlayDialog() {
        val dialogBinding = HowToPlayDialogBinding.inflate(layoutInflater)
        val dialogView = dialogBinding.root
        val okButton = dialogBinding.btnOk

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(true)

        val dialog = dialogBuilder.create()
        dialog.show()

        okButton.setOnClickListener {
            dialog.dismiss()
        }
    }

}