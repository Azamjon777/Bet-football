package qwer.runner.betfootball.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import qwer.runner.betfootball.App.Companion.appDatabase
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.DialogMatchResultBinding
import qwer.runner.betfootball.databinding.FragmentThirdGameBinding
import qwer.runner.betfootball.model.MatchEntity
import qwer.runner.betfootball.model.SavedModel
import java.text.DecimalFormat
import kotlin.random.Random

class ThirdGameFragment : Fragment() {
    private var _binding: FragmentThirdGameBinding? = null
    private val binding get() = _binding!!
    private var team1Img: String? = null
    private var team2Img: String? = null

    private val coefficientDecimalFormat = DecimalFormat("#0.00")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedTeam1 = sharedPreferences.getString("team1", null)
        val savedTeam2 = sharedPreferences.getString("team2", null)

        team1Img = sharedPreferences.getString("team1Img", null)
        team2Img = sharedPreferences.getString("team2Img", null)

        binding.team1Name.text = savedTeam1
        binding.team2Name.text = savedTeam2

        Glide.with(requireContext())
            .load(team1Img)
            .error(R.drawable.ic_img)
            .into(binding.team1Img)

        Glide.with(requireContext())
            .load(team2Img)
            .error(R.drawable.ic_img)
            .into(binding.team2Img)

        val firstTeamCoefficient = coefficientDecimalFormat.format(Random.nextDouble(1.0, 5.0))
        val drawTeamCoefficient = coefficientDecimalFormat.format(Random.nextDouble(1.0, 5.0))
        val secondTeamCoefficient = coefficientDecimalFormat.format(Random.nextDouble(1.0, 5.0))

        binding.firstTeamCoefficient.text = firstTeamCoefficient
        binding.drawTeamCoefficient.text = drawTeamCoefficient
        binding.secondTeamCoefficient.text = secondTeamCoefficient

        val betEditTexts = listOf(binding.firstTeamBet, binding.drawTeamBet, binding.secondTeamBet)

        if (savedTeam1 != null && savedTeam2 != null) {
            binding.btnStart.setOnClickListener {
                val nonEmptyBets = betEditTexts.filter { it.text.isNotEmpty() }

                if (nonEmptyBets.size == 1) {
                    val chosenBet = when {
                        binding.firstTeamBet.text.isNotEmpty() -> savedTeam1
                        binding.drawTeamBet.text.isNotEmpty() -> getString(R.string.draw)
                        binding.secondTeamBet.text.isNotEmpty() -> savedTeam2
                        else -> ""
                    }
                    lifecycleScope.launch(Dispatchers.Main) {
                        val firstTeamGoals = Random.nextInt(6)
                        val secondTeamGoals = Random.nextInt(6)

                        binding.progressBar.visibility = View.VISIBLE
                        delay(2000)
                        binding.btnStart.visibility = View.GONE
                        val resultText = when {
                            firstTeamGoals > secondTeamGoals -> "$savedTeam1" + getString(R.string.wins)
                            secondTeamGoals > firstTeamGoals -> "$savedTeam2" + getString(R.string.wins)
                            else -> getString(R.string.draw)
                        }

                        val playerWins = when {
                            (resultText == "$savedTeam1" + getString(R.string.wins) && chosenBet == savedTeam1) ||
                                    (resultText == "$savedTeam2" + getString(R.string.wins) && chosenBet == savedTeam2) ||
                                    (resultText == getString(R.string.draw) && chosenBet == getString(
                                        R.string.draw
                                    )) -> true

                            else -> false
                        }
                        showMatchResultDialog(
                            requireView(),
                            getString(R.string.match_result),
                            "$savedTeam1 $firstTeamGoals : $secondTeamGoals $savedTeam2\n$resultText\n\n" + getString(
                                R.string.you_bet_on
                            ) + "$chosenBet",
                            playerWins,
                            firstTeamGoals.toString(),
                            secondTeamGoals.toString()
                        )
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.place_a_bet_on_one_of_the_match_outcomes),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun showMatchResultDialog(
        view: View,
        title: String,
        message: String,
        playerWins: Boolean,
        firstTeamScore: String,
        secondTeamScore: String
    ) {
        val dialogBinding = DialogMatchResultBinding.inflate(LayoutInflater.from(view.context))
        val alertDialog = AlertDialog.Builder(view.context)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .create()

        dialogBinding.dialogTitle.text = title
        dialogBinding.dialogMessage.text = message

        if (playerWins) {
            dialogBinding.dialogOutcome.text = getString(R.string.congratulations_you_win)
        } else {
            dialogBinding.dialogOutcome.text = getString(R.string.sorry_you_didn_t_win_this_time)
        }

        dialogBinding.dialogRestartButton.setOnClickListener {
            alertDialog.dismiss()
            binding.firstTeamBet.setText("")
            binding.drawTeamBet.setText("")
            binding.secondTeamBet.setText("")
            binding.btnStart.visibility = View.VISIBLE

            val savedModel = SavedModel(
                team1Name = binding.team1Name.text.toString(),
                team2Name = binding.team2Name.text.toString(),
                team1Img = team1Img.toString(),
                team2Img = team2Img.toString(),
                team1Score = firstTeamScore,
                team2Score = secondTeamScore
            )
            saveMatchResult(savedModel)
        }
        alertDialog.show()
    }

    private fun saveMatchResult(savedModel: SavedModel) {

        val matchEntity = MatchEntity(
            team1Name = savedModel.team1Name,
            team2Name = savedModel.team2Name,
            team1Img = savedModel.team1Img,
            team2Img = savedModel.team2Img,
            team1Score = savedModel.team1Score,
            team2Score = savedModel.team2Score
        )

        val matchDao = appDatabase.matchDao()
        CoroutineScope(Dispatchers.IO).launch {
            matchDao.insertMatch(matchEntity)
        }
        findNavController().navigate(R.id.action_thirdGameFragment_to_finishedMatchesFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}