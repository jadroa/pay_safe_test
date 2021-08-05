package com.paysafe.stores.ui.dashboard

import androidx.fragment.app.viewModels
import com.paysafe.stores.databinding.FragmentDashboardBinding
import com.peek.peek_sensor.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel, DashboardState>(FragmentDashboardBinding::inflate) {
    override val viewModel: DashboardViewModel by viewModels()

    override fun updateUI(state: DashboardState) {
    }

    override fun setupViews() {
    }

}