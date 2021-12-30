package com.bacon.cryptocoin.presentation.ui.fragments.detail

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.App
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.common.factory.CoinsViewModelFactory
import com.bacon.cryptocoin.databinding.FragmentCoinsDetailBinding
import com.bacon.cryptocoin.presentation.state.UIState
import javax.inject.Inject

class CoinsDetailFragment : BaseFragment<FragmentCoinsDetailBinding, CoinsDetailViewModel>(
    R.layout.fragment_coins_detail
) {
    override val binding by viewBinding(FragmentCoinsDetailBinding::bind)

    @Inject
    lateinit var viewModelFactory: CoinsViewModelFactory
    override lateinit var viewModel: CoinsDetailViewModel
    private val args: CoinsDetailFragmentArgs by navArgs()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun initialize() {
        setupViewModel()
    }

    override fun setupListeners() {
        setUpSwipeRefreshLayout()
    }

    private fun setUpSwipeRefreshLayout() {

    }

    override fun setupObserves() {
        setUpCoinsDetail()
    }

    private fun setUpCoinsDetail() = with(binding) {
        viewModel.fetchCoinDetail(args.id)
        viewModel.fetchCoinsDetail.observe(viewLifecycleOwner, {
            when (it) {
                is UIState.Error -> {
                    Log.e("anime", "setupObserves: ${it.error}")
                }
                is UIState.Loading -> {
                    Log.e("anime", "setupObserves: $it")
                }
                is UIState.Success -> {
                    Log.e("anime", "setupObserves: ${it.data}")
                    toolbar.apply {
                        title = it.data.name
                        subtitle = it.data.symbol
                    }
                    name.text = it.data.name
                    symbol.text = it.data.symbol
                    rank.text = getString(R.string.rank_value, it.data.rank)
//                    priceToolbar.showPrice(it.data.price)
//                    price.showPrice(it.data.price)
//                    changeToolbar.showChange(it.data.percentChange24h)
//                    percentChange1h.showChange(it.data.percentChange1h)
//                    percentChange24h.showChange(it.data.percentChange24h)
//                    percentChange7d.showChange(it.data.percentChange7d)
//                    marketCap.showPrice(it.data.marketCap)
//                    availableSupply.showPrice(it.data.availableSupply)
//                    maxSupply.text = it.data.maxSupply
//                    volume24h.showPrice(it.data.volume24h)
//                    averagePrice24h.showPrice(it.data.averagePrice24h)
                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CoinsDetailViewModel::class.java)
    }
}