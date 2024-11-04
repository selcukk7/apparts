package com.example.apparts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.apparts.R

class ArtworkDetailActivity : AppCompatActivity() {

    private lateinit var artworkImageView: ImageView
    private lateinit var artworkTypeEditText: EditText
    private lateinit var hattatEditText: EditText
    private lateinit var tezhibEditText: EditText
    private lateinit var artworkDateEditText: EditText
    private lateinit var hattaYazanEditText: EditText
    private lateinit var purchaseDateEditText: EditText
    private lateinit var purchasePriceEditText: EditText
    private lateinit var purchaseChannelEditText: EditText
    private lateinit var saveButton: Button

    private lateinit var artwork: Artwork

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artwork_detail)

        artworkImageView = findViewById(R.id.artworkImageView)
        artworkTypeEditText = findViewById(R.id.artworkTypeEditText)
        hattatEditText = findViewById(R.id.hattatEditText)
        tezhibEditText = findViewById(R.id.tezhibEditText)
        artworkDateEditText = findViewById(R.id.artworkDateEditText)
        hattaYazanEditText = findViewById(R.id.hattaYazanEditText)
        purchaseDateEditText = findViewById(R.id.purchaseDateEditText)
        purchasePriceEditText = findViewById(R.id.purchasePriceEditText)
        purchaseChannelEditText = findViewById(R.id.purchaseChannelEditText)
        saveButton = findViewById(R.id.saveButton)

        artwork = intent.getParcelableExtra("artwork")!!

        // Eser bilgilerini yükle
        loadArtworkDetails()

        saveButton.setOnClickListener {
            saveArtworkDetails()
        }
    }

    private fun loadArtworkDetails() {
        // Eser detaylarını yükle ve görüntüle
    }

    private fun saveArtworkDetails() {
        // Eser bilgilerini kaydet
    }
}
