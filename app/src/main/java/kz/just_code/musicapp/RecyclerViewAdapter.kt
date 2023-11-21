package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val items: List<RecyclerViewItem>,
    private val onButtonClickListener: (Artist) -> Unit
) : ListAdapter<RecyclerViewItem, RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemType.HEADER.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_artist, parent, false)
                HeaderViewHolder(view)
            }
            ItemType.ITEM.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.add_artist, parent, false)
                ButtonViewHolder(view, onAddArtistClickListener)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is HeaderItem -> (holder as HeaderViewHolder).bind(item)
            is ButtonItem -> (holder as ButtonViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].itemType.ordinal
    }
}
