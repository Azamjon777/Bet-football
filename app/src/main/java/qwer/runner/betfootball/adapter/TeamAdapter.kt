package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import qwer.runner.betfootball.R
import qwer.runner.betfootball.databinding.ItemTeamBinding
import qwer.runner.betfootball.model.TeamModel

class TeamAdapter(
    private val teamList: List<TeamModel>,
    private val teamClickListener: TeamClickListener
) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(teamList[position])
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    inner class ViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val team = teamList[position]
                    teamClickListener.onTeamClick(team)
                }
            }
        }

        fun bind(team: TeamModel) {
            binding.teamNameTextView.text = team.teamName
            Glide.with(binding.root.context)
                .load(team.teamFlag)
                .error(R.drawable.ic_img)
                .into(binding.teamImg)
        }
    }

    interface TeamClickListener {
        fun onTeamClick(team: TeamModel)
    }
}
