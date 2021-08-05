package com.paysafe.stores.ui.stores

import com.peek.peek_sensor.base.ViewBindingDiffUtilCallback

object StoreDiffCallback : ViewBindingDiffUtilCallback<StoreItem>() {
    override fun areItemsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean = oldItem.name == newItem.name
}