package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.musicapp.databinding.ItemPlaylistBinding

class PlaylistsAdapter(
    private val playlistList: ArrayList<Playlist>,
    private val listener: (Playlist, Int) -> Unit
) : RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {
    class ViewHolder(var itemBinding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(playlist: Playlist) {
            itemBinding.imageView11.setImageResource(playlist.image)
            itemBinding.playlistTitle.text = playlist.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlaylistsAdapter.ViewHolder, position: Int) {
        holder.bindItem(playlistList[position])
        holder.itemView.setOnClickListener { listener(playlistList[position], position) }
    }

    override fun getItemCount(): Int {
        return playlistList.size
    }

}