package com.example.apparts



import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artwork(
    var id: Long,
    var name: String,
    var imagePath: String, // Resmin yolu
    var type: String,
    var hattat: String,
    var tezhib: String,
    var date: String,
    var hattaYazan: String,
    var purchaseDate: String,
    var purchasePrice: Double,
    var purchaseChannel: String,
    var isSold: Boolean = false,
    var soldTo: String? = null,
    var soldPrice: Double? = null
) : Parcelable
