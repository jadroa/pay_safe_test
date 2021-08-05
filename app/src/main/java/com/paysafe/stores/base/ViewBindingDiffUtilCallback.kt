package com.peek.peek_sensor.base

import androidx.recyclerview.widget.DiffUtil

abstract class ViewBindingDiffUtilCallback<Item : ViewBindingAdapterItem> :
    DiffUtil.ItemCallback<Item>()