package com.example.apparts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SoldArtworkActivity : AppCompatActivity() {
    private lateinit var soldToEditText: EditText
    private lateinit var soldPriceEditText: EditText
    private lateinit var markSoldButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sold_artwork)

        soldToEditText = findViewById(R.id.soldToEditText)
        soldPriceEditText = findViewById(R.id.soldPriceEditText)
        markSoldButton = findViewById(R.id.markSoldButton)

        markSoldButton.setOnClickListener {
            // Satıldı butonu işlemleri
        }
    }
}
