package com.example.apparts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FilterActivity : AppCompatActivity() {
    private lateinit var startDateEditText: EditText
    private lateinit var endDateEditText: EditText
    private lateinit var minPriceEditText: EditText
    private lateinit var maxPriceEditText: EditText
    private lateinit var filterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        startDateEditText = findViewById(R.id.startDateEditText)
        endDateEditText = findViewById(R.id.endDateEditText)
        minPriceEditText = findViewById(R.id.minPriceEditText)
        maxPriceEditText = findViewById(R.id.maxPriceEditText)
        filterButton = findViewById(R.id.filterButton)

        filterButton.setOnClickListener {
            applyFilters()
        }
    }

    private fun applyFilters() {
        // Filtreleri uygula ve sonucu göster
    }
}
