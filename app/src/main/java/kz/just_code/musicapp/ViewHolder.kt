package kz.just_code.musicapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(headerItem: HeaderItem) {

        val titleTextView: TextView = itemView.findViewById(R.id.artist_name)
        titleTextView.text = headerItem.title
    }
}

class ButtonViewHolder(itemView: View, private val onButtonClickListener: (AddArtist) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(buttonItem: ButtonItem) {
        itemView.setOnClickListener { onButtonClickListener.invoke(buttonItem.addArtist) }
    }
}

