package com.paysafe.stores.ui.stores

import android.view.ViewGroup
import com.paysafe.stores.databinding.ItemStoreBinding
import com.paysafe.stores.model.Store
import com.peek.peek_sensor.base.ViewBindingAdapter
import com.peek.peek_sensor.base.ViewBindingAdapterItem
import com.peek.peek_sensor.base.ViewBindingViewHolder

data class StoreItem(
    val name: String? = null
) : ViewBindingAdapterItem {
    companion object {
        const val STORE = 1
    }
    override val itemViewType: Int = STORE
}

class StoresAdapter : ViewBindingAdapter<StoreItem, ItemStoreBinding>(StoreDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingViewHolder<StoreItem, ItemStoreBinding> {
        val inflater = parent.layoutInflater
        return when (viewType) {
            StoreItem.STORE -> {
                val binding = ItemStoreBinding.inflate(inflater, parent, false)
                StoreItemViewHolder(binding)
            }
            else -> throw IllegalStateException("Incorrect view type")
        }
    }

    inner class StoreItemViewHolder(binding: ItemStoreBinding) :
        ViewBindingViewHolder<StoreItem, ItemStoreBinding>(binding) {
        override fun bind(item: StoreItem) {
            binding.deviceName.text = item.name
        }
    }
}