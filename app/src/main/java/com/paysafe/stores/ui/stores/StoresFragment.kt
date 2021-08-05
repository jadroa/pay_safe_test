package com.paysafe.stores.ui.stores

import androidx.fragment.app.viewModels
import com.paysafe.stores.databinding.FragmentStoresBinding
import com.peek.peek_sensor.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoresFragment : BaseFragment<FragmentStoresBinding, StoresViewModel, StoresState>(FragmentStoresBinding::inflate) {
    override val viewModel: StoresViewModel by viewModels()
    private val scanResultAdapter = StoresAdapter()

    override fun updateUI(state: StoresState) {
        state.location?.let {
            requireBinding().longitude.text = it.longitude.toString()
            requireBinding().latitude.text = it.latitude.toString()
        }
        val items = state.toStoreItems()
        scanResultAdapter.submitList(items)
    }

    override fun setupViews() {
        requireBinding().stores.adapter = StoresAdapter()
        requireBinding().findStores.setOnClickListener {
            viewModel.findStores()
        }
        viewModel.startLocationUpdates()
    }

    private fun StoresState.toStoreItems(): List<StoreItem> = stores?.map { StoreItem(name = it.name) } ?: listOf()
}