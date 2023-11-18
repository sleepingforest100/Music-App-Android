package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter() :
    ListAdapter<AlbumItem, AlbumViewHolder>(AlbumDiffUtils()) {

    class AlbumDiffUtils: DiffUtil.ItemCallback<AlbumItem>(){
        override fun areItemsTheSame(oldItem: AlbumItem, newItem: AlbumItem): Boolean {
           return oldItem.data?.uri == newItem.data?.uri
        }

        override fun areContentsTheSame(oldItem: AlbumItem, newItem: AlbumItem): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_albums_response, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}