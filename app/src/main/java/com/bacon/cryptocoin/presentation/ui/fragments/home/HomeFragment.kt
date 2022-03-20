package com.bacon.cryptocoin.presentation.ui.fragments.home

import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.databinding.FragmentHomeBinding
import com.bacon.cryptocoin.presentation.state.UIState
import com.bacon.cryptocoin.presentation.ui.adapters.CoinsAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {
    override val binding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    override val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    private val adapter = CoinsAdapter(this::setOnItemClickListener)


    override fun initializeSubComponent() {
        getInjector().createCoinsSubComponent().inject(this)
    }

    override fun initialize() {
        binding.rvCoins.adapter = adapter
    }

    override fun setupObserves() {
        viewModel.fetchCoinsState.subscribe {
            binding.progressBarCoin.isVisible = it is UIState.Loading
            when (it) {
                is UIState.Error -> {
                    Log.e("tag", "Error Coins ${it.error}")
                }
                is UIState.Loading -> {
                    Log.e("tag", "Loading Coins $it")
                }
                is UIState.Success -> {
                    Log.e("tag", "Success Coins ${it.data}")
                    adapter.submitList(it.data)
                }
            }
        }
    }

    private fun setOnItemClickListener(id: String) {
        Toast.makeText(requireContext(), "Ids $id", Toast.LENGTH_SHORT).show()
    }
}