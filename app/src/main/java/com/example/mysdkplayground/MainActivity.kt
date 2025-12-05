package com.example.mysdkplayground

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bananatracker.Banana

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize BananaTracker SDK
        Banana.initialize(
            context = this,
            config = Banana.Config(
                apiKey = "your-api-key-here",
                debugMode = true
            )
        )
        
        // Track an event
        Banana.trackEvent("app_launched")
        
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Track another event after UI is set up
        Banana.trackEvent("main_activity_created")
    }
}