package kz.just_code.musicapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val albumImageView: ImageView = itemView.findViewById(R.id.album_image_box)
    private val albumNameTextView: TextView = itemView.findViewById(R.id.album_title)

    fun bind(albumData: AlbumItem) {
        // Set album name
        albumNameTextView.text = albumData.data?.name

        // Load album icon using Glide (or your preferred image loading library)
        Glide.with(itemView)
            .load(albumData.data?.coverArt?.sources?.firstOrNull()?.url)
            .into(albumImageView)
    }
}