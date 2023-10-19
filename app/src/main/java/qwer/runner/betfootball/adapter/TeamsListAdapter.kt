package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.ItemTeamBinding
import qwer.runner.betfootball.model.TeamModel

class TeamsListAdapter(
    private val teams: List<TeamModel>,
    private val teamClickListener: OnTeamClickListener
) : RecyclerView.Adapter<TeamsListAdapter.TeamViewHolder>() {

    interface OnTeamClickListener {
        fun onTeamClick(team: TeamModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentTeam = teams[position]
        holder.bind(currentTeam, teamClickListener)
    }

    override fun getItemCount() = teams.size

    class TeamViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: TeamModel, teamClickListener: OnTeamClickListener) {
            binding.teamNameTextView.text = team.teamName
            Glide.with(binding.root)
                .load(team.teamFlag)
                .placeholder(R.drawable.ic_img)
                .error(R.drawable.ic_img)
                .into(binding.teamImg)

            binding.root.setOnClickListener {
                teamClickListener.onTeamClick(team)
            }
        }

        companion object {
            fun from(parent: ViewGroup): TeamViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTeamBinding.inflate(layoutInflater, parent, false)
                return TeamViewHolder(binding)
            }
        }
    }
}