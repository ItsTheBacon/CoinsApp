package com.bacon.cryptocoin.presentation.ui.fragments.search

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bacon.cryptocoin.R
import com.bacon.cryptocoin.common.base.BaseFragment
import com.bacon.cryptocoin.databinding.FragmentSearchBinding


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(
    R.layout.fragment_search
) {
    override val binding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels()


}

