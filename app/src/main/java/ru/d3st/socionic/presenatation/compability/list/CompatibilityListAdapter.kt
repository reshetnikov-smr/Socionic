package ru.d3st.socionic.presenatation.compability.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.d3st.socionic.databinding.ItemCompatibilityListBinding
import ru.d3st.socionic.models.Comparison

class CompatibilityListAdapter(private val clickListener: CompatibilityClickListener) :
    ListAdapter<Comparison, CompatibilityListAdapter.ViewHolder>(CompatibilityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(item.id, item.compatibilityTitle)
        }
        holder.bind(item)
    }

    //обработка кликов
    class CompatibilityClickListener(val click: (characterId: Int, compatibility:String) -> Unit) {
        fun onClick(characterId: Int, compatibility:String) = click(characterId, compatibility)
    }

    class ViewHolder private constructor(private val binding: ItemCompatibilityListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Comparison) {
            binding.character = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCompatibilityListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

//Класс для сравнения списков при обновлении
class CompatibilityDiffCallback : DiffUtil.ItemCallback<Comparison>() {
    override fun areItemsTheSame(oldItem: Comparison, newItem: Comparison): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comparison, newItem: Comparison): Boolean {
        return oldItem == newItem
    }

}

