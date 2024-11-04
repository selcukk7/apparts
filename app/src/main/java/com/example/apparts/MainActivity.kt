package com.example.apparts

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var myArtworksButton: Button
    private lateinit var uploadButton: Button
    private lateinit var exportButton: Button
    private lateinit var artworkListView: ListView

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_CODE)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // İzin verildi, gerekli işlemleri yap
            } else {
                // İzin verilmedi, kullanıcıyı bilgilendirin
            }
        }
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1
    }

    private fun createArtworkDirectory(): File {
        val directory = File(getExternalFilesDir(null), "Artworks")
        if (!directory.exists()) {
            directory.mkdirs() // Klasör yoksa oluştur
        }
        return directory
    }

    private fun saveArtworkData(artwork: Artwork) {
        val directory = createArtworkDirectory()

        // Eser bilgilerini bir metin dosyasına kaydet
        val fileName = "${artwork.name}.txt"
        val file = File(directory, fileName)

        file.writeText("Eser Adı: ${artwork.name}\n" +
                "Eser Türü: ${artwork.type}\n" +
                "Hattat: ${artwork.hattat}\n" +
                "Tezhib: ${artwork.tezhib}\n" +
                "Eserin Tarihi: ${artwork.date}\n" +
                "Alış Tarihi: ${artwork.purchaseDate}\n" +
                "Alış Fiyatı: ${artwork.purchasePrice}\n" +
                "Alış Kanalı: ${artwork.purchaseChannel}\n" +
                "Satıldı: ${artwork.isSold}\n" +
                "Satıldığı Kişi: ${artwork.soldTo}\n" +
                "Satış Fiyatı: ${artwork.soldPrice}\n")
    }

    private fun saveArtworkImage(artwork: Artwork, imageStream: InputStream) {
        val directory = createArtworkDirectory()
        val artworkImageDirectory = File(directory, artwork.name)
        if (!artworkImageDirectory.exists()) {
            artworkImageDirectory.mkdirs() // Fotoğraf klasörü yoksa oluştur
        }

        // Fotoğrafı kaydet
        val photoFile = File(artworkImageDirectory, "${artwork.name}.jpg")
        val outputStream = FileOutputStream(photoFile)

        imageStream.copyTo(outputStream) // Fotoğrafı kaydet
        outputStream.close()
        imageStream.close()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        myArtworksButton = findViewById(R.id.myArtworksButton)
        uploadButton = findViewById(R.id.uploadButton)
        exportButton = findViewById(R.id.exportButton)
        artworkListView = findViewById(R.id.artworkListView)

        myArtworksButton.setOnClickListener {
            startActivity(Intent(this, MyArtworksActivity::class.java))
        }

        uploadButton.setOnClickListener {
            // Eser yükleme işlemi için intent başlat
        }

        exportButton.setOnClickListener {
            // Excel'e aktarma işlemi
        }

        searchEditText.setOnEditorActionListener { _, _, _ ->
            performSearch(searchEditText.text.toString())
            true
        }
    }

    private fun performSearch(query: String) {
        // Arama işlemi yapılacak
    }
}
