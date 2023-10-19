package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import qwer.runner.betfootball.databinding.ItemPlayerBinding

class PlayersAdapter(private val players: List<String>) :
    RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(player: String) {
            binding.playerNameTextView.text = player
        }

        companion object {
            fun from(parent: ViewGroup): PlayerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPlayerBinding.inflate(layoutInflater, parent, false)
                return PlayerViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val currentPlayer = players[position]
        holder.bind(currentPlayer)
    }

    override fun getItemCount() = players.size
}