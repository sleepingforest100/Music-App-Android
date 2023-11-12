package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.musicapp.databinding.ItemPlaylistBinding

class PlaylistsAdapter() :
    ListAdapter<Playlist, PlaylistsAdapter.PlaylistViewHolder>(PlaylistDiffUtils()) {
    class PlaylistDiffUtils : DiffUtil.ItemCallback<Playlist>() {
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem == newItem
        }

    }

   inner class PlaylistViewHolder(var itemBinding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(playlist: Playlist) {
            itemBinding.playlistIcon.setImageResource(playlist.image)
            itemBinding.playlistTitle.text = playlist.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val v = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlaylistsAdapter.PlaylistViewHolder, position: Int) {
        holder.bindItem(getItem(position))
        holder.itemView.setOnClickListener { listener?.invoke(getItem(position)) }
    }

    var listener: ((Playlist) -> Unit)? = null

}
