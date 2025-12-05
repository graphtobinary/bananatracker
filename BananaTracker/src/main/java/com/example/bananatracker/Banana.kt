package com.example.bananatracker

import android.content.Context
import android.util.Log

object Banana {
    private const val TAG = "BananaTracker"
    private var isInitialized = false

    // Configuration object to hold API keys, etc.
    data class Config(val apiKey: String, val debugMode: Boolean = false)

    fun initialize(context: Context, config: Config) {
        if (isInitialized) {
            Log.w(TAG, "Banana SDK is already initialized")
            return
        }
        // Perform setup logic here (e.g., init database, network)
        isInitialized = true
        Log.i(TAG, "Banana SDK initialized with API Key: ${config.apiKey}")
    }

    fun trackEvent(eventName: String) {
        if (!isInitialized) {
            Log.e(TAG, "Banana SDK not initialized! Call initialize() first.")
            return
        }
        Log.d(TAG, "Tracking Event: $eventName")
        // logic to send event to server would go here
    }
}