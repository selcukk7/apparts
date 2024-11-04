package com.example.apparts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ArtworkAdapter(private val context: Context, private val artworks: List<Artwork>) : BaseAdapter() {
    override fun getCount(): Int {
        return artworks.size
    }

    override fun getItem(position: Int): Artwork {
        return artworks[position]
    }

    override fun getItemId(position: Int): Long {
        return artworks[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.artwork_item, parent, false)

        val artwork = getItem(position)
        val nameTextView = view.findViewById<TextView>(R.id.artworkNameTextView)
        val imageView = view.findViewById<ImageView>(R.id.artworkImageView)

        nameTextView.text = artwork.name

        // Glide ile resmi yükleyin
        Glide.with(context)
            .load(artwork.imagePath)
            .into(imageView)

        return view
    }
}
