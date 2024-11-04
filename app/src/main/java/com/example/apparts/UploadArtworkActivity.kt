package com.example.apparts

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class UploadArtworkActivity : AppCompatActivity() {
    private lateinit var artworkImageView: ImageView
    private lateinit var uploadImageButton: Button
    private lateinit var typeEditText: EditText
    private lateinit var artistEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var channelEditText: EditText
    private lateinit var submitButton: Button

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_artwork)

        artworkImageView = findViewById(R.id.artworkImageView)
        uploadImageButton = findViewById(R.id.uploadImageButton)
        typeEditText = findViewById(R.id.typeEditText)
        artistEditText = findViewById(R.id.artistEditText)
        dateEditText = findViewById(R.id.dateEditText)
        priceEditText = findViewById(R.id.priceEditText)
        channelEditText = findViewById(R.id.channelEditText)
        submitButton = findViewById(R.id.submitButton)

        uploadImageButton.setOnClickListener {
            openGallery()
        }

        submitButton.setOnClickListener {
            // Eser kaydetme işlemleri
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            artworkImageView.setImageURI(selectedImageUri)
        }
    }

    companion object {
        const val IMAGE_PICK_CODE = 1000
    }
}
