package com.bacon.cryptocoin.presentation.ui.fragments.home

import android.content.Context
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.App
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.common.factory.ViewModelFactory
import com.bacon.cryptocoin.databinding.FragmentHomeBinding
import com.bacon.cryptocoin.presentation.state.UIState
import com.bacon.cryptocoin.presentation.ui.adapters.CoinsAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {
    override val binding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override lateinit var viewModel: HomeViewModel
    private val adapter = CoinsAdapter(this::setOnItemClickListener)


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun initialize() {
        binding.rvCoins.adapter = adapter
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(HomeViewModel::class.java)
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
        findNavController().navigate(
            HomeFragmentDirections
                .actionHomeFragmentToCoinsDetailFragment(id)
        )
    }
}