package ru.d3st.socionic.presenatation.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.d3st.socionic.databinding.ItemPersonsListBinding
import ru.d3st.socionic.models.presentation.CharacterDescription

class OverviewListAdapter(private val clickListener: CharacterClickListener) :
        ListAdapter<CharacterDescription, OverviewListAdapter.ViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(it, item.id)
        }
        holder.bind(item)
    }

    //обработка кликов
    class CharacterClickListener(val click: (view: View, characterId: Int) -> Unit) {
        fun onClick(view: View, characterId: Int) = click(view, characterId)
    }

    class ViewHolder private constructor(private val binding: ItemPersonsListBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterDescription) {
            binding.character = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPersonsListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

//Класс для сравнения списков при обновлении
class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDescription>() {
    override fun areItemsTheSame(oldItem: CharacterDescription, newItem: CharacterDescription): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterDescription, newItem: CharacterDescription): Boolean {
        return oldItem == newItem
    }

}

