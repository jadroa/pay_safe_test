package com.paysafe.stores.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationManager @Inject constructor(private val fusedLocationProviderClient: FusedLocationProviderClient) {
    companion object {
        const val UPDATE_INTERVAL: Long = 5000
        const val FASTEST_UPDATE_INTERVAL: Long = 1000
    }

    fun startLocationUpdates(): Flow<Location> = fusedLocationProviderClient.locationFlow()

    @SuppressLint("MissingPermission")
    private fun FusedLocationProviderClient.locationFlow() = callbackFlow<Location> {
        val callback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult?) {
                result ?: return
                try { trySend(result.lastLocation) } catch(e: Exception) {}
            }
        }

        requestLocationUpdates(LocationRequest.create().also {
            it.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            it.interval = UPDATE_INTERVAL
            it.fastestInterval = FASTEST_UPDATE_INTERVAL
        }, callback, Looper.getMainLooper())
            .addOnFailureListener { e ->
                close(e)
            }
        awaitClose {
            removeLocationUpdates(callback)
        }
    }
}