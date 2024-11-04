package com.example.apparts

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SearchResultsActivity : AppCompatActivity() {
    private lateinit var resultsListView: ListView
    private lateinit var searchResults: List<Artwork>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        resultsListView = findViewById(R.id.resultsListView)

        // Arama sonuçlarını almak için Intent kullanın
        searchResults = intent.getParcelableArrayListExtra("searchResults")!!

        val adapter = ArtworkAdapter(this, searchResults)
        resultsListView.adapter = adapter
    }
}
