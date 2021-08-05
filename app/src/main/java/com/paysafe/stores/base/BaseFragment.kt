package com.peek.peek_sensor.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB: ViewBinding, BVM: BaseViewModel<State>, State>(
        private val inflate: Inflate<VB>
) : Fragment() {
        private var binding: VB? = null
        protected abstract val viewModel: BVM

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                binding = inflate.invoke(inflater, container, false)
                return requireBinding().root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                setupViews()
                viewLifecycleOwner.lifecycleScope.launch {
                        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.stateFlow.collect() {
                                        updateUI(it)
                                }
                        }
                }
        }

        protected abstract fun updateUI(state: State)

        protected abstract fun setupViews()

        protected fun requireBinding() = requireNotNull(binding)
}