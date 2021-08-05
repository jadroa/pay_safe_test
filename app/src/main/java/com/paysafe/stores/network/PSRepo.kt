package com.paysafe.stores.network

import com.paysafe.stores.model.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PSRepo @Inject constructor(
    private val api: PSApi
) {
    fun getStores(
        longitude: Double,
        latitude: Double,
        radius: Int,
        pageSize: Int,
        clientAppKey: String
    ): Flow<List<Store>> = flow {
        val stores = api.getStores(
            longitude,
            latitude,
            radius,
            pageSize,
            clientAppKey
        )
        emit(stores)
    }.flowOn(Dispatchers.IO)
}