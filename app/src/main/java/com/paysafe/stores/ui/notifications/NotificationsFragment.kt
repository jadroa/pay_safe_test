package com.paysafe.stores.ui.notifications

import androidx.fragment.app.viewModels
import com.paysafe.stores.databinding.FragmentNotificationsBinding
import com.peek.peek_sensor.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel, NotificationState>(FragmentNotificationsBinding::inflate) {
    override val viewModel: NotificationsViewModel by viewModels()

    override fun updateUI(state: NotificationState) {
    }

    override fun setupViews() {
    }
}