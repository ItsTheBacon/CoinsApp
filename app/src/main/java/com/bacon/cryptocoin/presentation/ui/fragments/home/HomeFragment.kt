package com.bacon.cryptocoin.presentation.ui.fragments.home

import android.content.Context
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.App
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.common.factory.ViewModelFactory
import com.bacon.cryptocoin.databinding.FragmentHomeBinding
import com.bacon.cryptocoin.presentation.ui.adapters.CoinsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        adapter.addLoadStateListener {
            if (view != null) {
                binding.rvCoins.isVisible = it.refresh is LoadState.NotLoading
                binding.progressBarCoin.isVisible = it.refresh is LoadState.Loading
            }
        }
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(HomeViewModel::class.java)
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchCoins().collectLatest {
                adapter.submitData(it)
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