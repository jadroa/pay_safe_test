package com.paysafe.stores.model

import kotlinx.serialization.Serializable
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class Store (
    val posId: Long,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val postalCode: Int,
    val city: String,
    val distributorId: Long,
    val country: String,
    val posTypeLogo: String,
    val productLogo: String,
    val specialText: String,
    val recomended: Boolean,
    val storeFeedbacks: StoreFeedback,
    val directload: Boolean,
    val mdirectload: Boolean
)

data class StoreFeedback(
    val feedbackName: String,
    val feedbackCount: Int
)