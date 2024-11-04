package com.example.apparts

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MyArtworksActivity : AppCompatActivity() {

    private lateinit var artworksListView: ListView
    private lateinit var artworks: MutableList<Artwork>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_artworks)

        artworksListView = findViewById(R.id.artworksListView)
        artworks = mutableListOf()

        loadArtworks() // Eserleri yükle
        setupListView()
    }

    private fun loadArtworks() {
        artworks.add(Artwork(1, "Eser 1", "path/to/image1.jpg", "Tür 1", "Hattat 1", "Tezhib 1", "2024-11-01", "Hatta Yazan 1", "2024-11-02", 100.0, "Kanal 1", false, "", 0.0))
        artworks.add(Artwork(2, "Eser 2", "path/to/image2.jpg", "Tür 2", "Hattat 2", "Tezhib 2", "2024-11-01", "Hatta Yazan 2", "2024-11-02", 200.0, "Kanal 2", false, "", 0.0))
    }

    private fun setupListView() {
        val adapter = ArtworkAdapter(this, artworks)
        artworksListView.adapter = adapter

        artworksListView.setOnItemClickListener { _, _, position, _ ->
            val selectedArtwork = artworks[position]
            val intent = Intent(this, ArtworkDetailActivity::class.java).apply {
                putExtra("artwork", selectedArtwork)
            }
            startActivity(intent)
        }
    }
}
