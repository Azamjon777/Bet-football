package qwer.runner.betfootball.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import qwer.runner.betfootball.databinding.ItemThirdBinding
import qwer.runner.betfootball.model.TacticsModel

class TacticsAdapter(
    private val tacticsList: List<TacticsModel>,
    private val onItemClick: OnItemClickListener
) : RecyclerView.Adapter<TacticsAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(tacticsModel: TacticsModel)
    }

    inner class ViewHolder(private val binding: ItemThirdBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.tvStyle

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val currentTactics = tacticsList[position]
                    onItemClick.onItemClick(currentTactics)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemThirdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentTactics = tacticsList[position]
        holder.titleTextView.text = currentTactics.title
    }

    override fun getItemCount(): Int {
        return tacticsList.size
    }
}

