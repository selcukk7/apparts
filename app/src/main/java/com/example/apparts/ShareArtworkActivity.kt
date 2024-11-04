package com.example.apparts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ShareArtworkActivity : AppCompatActivity() {
    private lateinit var artworkUri: Uri
    private lateinit var shareButton: Button
    private lateinit var titleCheckBox: CheckBox
    private lateinit var artistCheckBox: CheckBox
    private lateinit var typeCheckBox: CheckBox
    private lateinit var dateCheckBox: CheckBox
    private lateinit var priceCheckBox: CheckBox
    private lateinit var channelCheckBox: CheckBox
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_artwork)

        artworkUri = intent.getParcelableExtra("artworkUri")!!

        titleCheckBox = findViewById(R.id.titleCheckBox)
        artistCheckBox = findViewById(R.id.artistCheckBox)
        typeCheckBox = findViewById(R.id.typeCheckBox)
        dateCheckBox = findViewById(R.id.dateCheckBox)
        priceCheckBox = findViewById(R.id.priceCheckBox)
        channelCheckBox = findViewById(R.id.channelCheckBox)
        messageEditText = findViewById(R.id.messageEditText)
        shareButton = findViewById(R.id.shareButton)

        shareButton.setOnClickListener {
            shareArtwork()
        }
    }

    private fun shareArtwork() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/jpeg"
            putExtra(Intent.EXTRA_STREAM, artworkUri)

            // Paylaşılacak metni oluştur
            val message = StringBuilder()
            if (titleCheckBox.isChecked) {
                message.append("Eser Adı: ${messageEditText.text}\n")
            }
            if (artistCheckBox.isChecked) {
                message.append("Hattat: ${messageEditText.text}\n")
            }
            if (typeCheckBox.isChecked) {
                message.append("Eser Türü: ${messageEditText.text}\n")
            }
            if (dateCheckBox.isChecked) {
                message.append("Eser Tarihi: ${messageEditText.text}\n")
            }
            if (priceCheckBox.isChecked) {
                message.append("Alış Fiyatı: ${messageEditText.text}\n")
            }
            if (channelCheckBox.isChecked) {
                message.append("Alış Kanalı: ${messageEditText.text}\n")
            }

            putExtra(Intent.EXTRA_TEXT, message.toString())
        }
        startActivity(Intent.createChooser(shareIntent, "Eseri paylaş"))
    }
}
