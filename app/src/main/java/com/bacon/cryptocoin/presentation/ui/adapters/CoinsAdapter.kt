package com.bacon.cryptocoin.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseDiffUtilItemCallback
import com.bacon.cryptocoin.data.remote.dtos.CoinsDto
import com.bacon.cryptocoin.databinding.ItemCoinsBinding
import com.bacon.cryptocoin.presentation.ui.adapters.CoinsAdapter.ViewHolder


class CoinsAdapter(
    private val onItemClick: (id: String) -> Unit
) : PagingDataAdapter<CoinsDto, ViewHolder>(BaseDiffUtilItemCallback()) {

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
        private val binding: ItemCoinsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition).apply { onItemClick(this?.id.toString()) }
            }
        }

        fun onBind(coin: CoinsDto) = with(binding) {
            rank.text = itemView.context.getString(R.string.rank_coins, coin.rank)
            name.text = coin.name
            symbol.text = coin.symbol

        }

    }
}