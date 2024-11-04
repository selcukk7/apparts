package com.example.apparts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    private lateinit var priceRangeEditText: EditText
    private lateinit var dateRangeEditText: EditText
    private lateinit var filterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        priceRangeEditText = findViewById(R.id.priceRangeEditText)
        dateRangeEditText = findViewById(R.id.dateRangeEditText)
        filterButton = findViewById(R.id.filterButton)

        filterButton.setOnClickListener {
            // Filtreleme işlemi
        }
    }
}
