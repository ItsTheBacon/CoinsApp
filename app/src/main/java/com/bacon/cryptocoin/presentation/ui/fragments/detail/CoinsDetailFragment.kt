package com.bacon.cryptocoin.presentation.ui.fragments.detail

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.databinding.FragmentCoinsDetailBinding
import com.bacon.cryptocoin.presentation.state.UIState
import javax.inject.Inject

class CoinsDetailFragment : BaseFragment<FragmentCoinsDetailBinding, CoinsDetailViewModel>(
    R.layout.fragment_coins_detail
) {
    override val binding by viewBinding(FragmentCoinsDetailBinding::bind)

    @Inject
    lateinit var viewModelFactory: CoinsViewModelFactory
    private val args: CoinsDetailFragmentArgs by navArgs()
    override val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(CoinsDetailViewModel::class.java)
    }

    override fun setupObserves() {
        setUpCoinsDetail()
    }

    private fun setUpCoinsDetail() = with(binding) {
        viewModel.fetchCoinDetail(args.id)
        viewModel.fetchCoinsDetail.subscribe {
            when (it) {
                is UIState.Error -> {
                    Log.e("anime", "Error CoinsDetail: ${it.error}")
                }
                is UIState.Loading -> {
                    Log.e("anime", "Loading CoinsDetail: $it")
                }
                is UIState.Success -> {
                    Log.e("anime", "Success CoinsDetail: ${it.data}")
                    it.data.map { data ->
                        toolbar.apply {
                            title = data.pair
                            subtitle = data.exchange
                        }
                        name.text = data.pair
                        symbol.text = data.exchange
                    }
                }
            }
        }
    }

}