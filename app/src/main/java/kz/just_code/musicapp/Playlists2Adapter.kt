package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.musicapp.databinding.ItemPlaylist2Binding

class Playlists2Adapter() :
    ListAdapter<PlaylistSecondList, Playlists2Adapter.PlaylistSecondViewHolder>(Playlist2DiffUtils()) {
    inner class PlaylistSecondViewHolder(var itemBinding: ItemPlaylist2Binding) :
        RecyclerView.ViewHolder(itemBinding.root) {
fun bindItem(playlist: PlaylistSecondList){
    itemBinding.playlistIcon2.setImageResource(playlist.image)
    itemBinding.itemMusicTitle.text = playlist.title
    itemBinding.itemPlaylistDescription.text = playlist.description
}
    }

    class Playlist2DiffUtils : DiffUtil.ItemCallback<PlaylistSecondList>() {
        override fun areItemsTheSame(oldItem: PlaylistSecondList, newItem: PlaylistSecondList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlaylistSecondList, newItem: PlaylistSecondList): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistSecondViewHolder {
        var p = ItemPlaylist2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
   return PlaylistSecondViewHolder(p)
    }

    override fun onBindViewHolder(holder: PlaylistSecondViewHolder, position: Int) {
       holder.bindItem(getItem(position))
        holder.itemView.setOnClickListener { listener2?.invoke(getItem(position)) }
    }

var listener2: ((PlaylistSecondList)->Unit)?=null
}