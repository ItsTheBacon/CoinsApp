package com.bacon.cryptocoin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bacon.cryptocoin.common.base.BaseDiffUtilItemCallback
import com.bacon.cryptocoin.common.extensions.setOnSingleClickListener
import com.bacon.cryptocoin.databinding.ItemCoinsBinding
import com.bacon.cryptocoin.presentation.models.CoinsItemUI
import com.bacon.cryptocoin.presentation.ui.adapters.CoinsAdapter.ViewHolder


class CoinsAdapter(
    private val onItemClick: (id: String) -> Unit,
) : ListAdapter<CoinsItemUI, ViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCoinsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ViewHolder(
        private val binding: ItemCoinsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnSingleClickListener {
                getItem(absoluteAdapterPosition)?.apply {
                    onItemClick(this.id.toString())
                }
            }
        }

        fun onBind(coin: CoinsItemUI) = with(binding) {
            name.text = coin.name
            symbol.text = coin.symbol
            itemImage.load(coin.icon)
        }
    }
}