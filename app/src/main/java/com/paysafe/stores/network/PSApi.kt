package com.paysafe.stores.network

import com.paysafe.stores.model.Store
import retrofit2.http.GET
import retrofit2.http.Query

interface PSApi {

    @GET("rest/stores")
    suspend fun getStores(
        @Query("longitude") longitude: Double,
        @Query("latitude") latitude: Double,
        @Query("radius") radius: Int,
        @Query("pageSize") pageSize: Int,
        @Query("clientApplicationKey") clientAppKey: String
    ): List<Store>
}