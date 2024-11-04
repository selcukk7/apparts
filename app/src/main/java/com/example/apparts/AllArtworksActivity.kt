package com.example.apparts

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AllArtworksActivity : AppCompatActivity() {
    private lateinit var allArtworksListView: ListView
    private lateinit var artworks: List<Artwork>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_artworks)

        allArtworksListView = findViewById(R.id.allArtworksListView)
        loadAllArtworks()
    }

    private fun loadAllArtworks() {
        artworks = listOf(
            Artwork(1, "Eser 1", "path/to/photo1.jpg", "Tür 1", "Hattat 1", "Tezhib 1", "2023", "Hattat 1", "01/01/2023", 100.0, "Kanal 1"),
            Artwork(2, "Eser 2", "path/to/photo2.jpg", "Tür 2", "Hattat 2", "Tezhib 2", "2023", "Hattat 2", "01/02/2023", 150.0, "Kanal 2")
            // Diğer eserleri ekleyin...
        )

        val adapter = ArtworkAdapter(this, artworks)
        allArtworksListView.adapter = adapter
    }
}
