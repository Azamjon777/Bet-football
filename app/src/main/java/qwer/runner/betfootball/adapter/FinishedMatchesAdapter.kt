package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.ItemFinishedMatchBinding
import qwer.runner.betfootball.model.MatchEntity

class FinishedMatchesAdapter(private val matches: List<MatchEntity>) :
    RecyclerView.Adapter<FinishedMatchesAdapter.MatchViewHolder>() {

    class MatchViewHolder(private val binding: ItemFinishedMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: MatchEntity) {
            binding.team1Name.text = match.team1Name
            binding.team2Name.text = match.team2Name
            binding.team1Score.text = match.team1Score
            binding.team2Score.text = match.team2Score
            Glide.with(binding.root)
                .load(match.team1Img)
                .error(R.drawable.ic_img)
                .into(binding.team1Img)

            Glide.with(binding.root)
                .load(match.team2Img)
                .error(R.drawable.ic_img)
                .into(binding.team2Img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ItemFinishedMatchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matches[position]
        holder.bind(match)
    }

    override fun getItemCount() = matches.size
}
