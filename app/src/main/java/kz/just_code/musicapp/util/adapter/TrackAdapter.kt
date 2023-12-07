package kz.just_code.musicapp.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.musicapp.util.TrackViewHolder
import kz.just_code.musicapp.data.model.SongTrackItem
import kz.just_code.musicapp.databinding.ItemTrackBinding

class TrackAdapter() :
    ListAdapter<SongTrackItem, TrackViewHolder>(AlbumDiffUtils()) {

    var click: ((SongTrackItem) -> Unit)? = null
    var like: ((SongTrackItem) -> Unit)? = null

    class AlbumDiffUtils: DiffUtil.ItemCallback<SongTrackItem>(){
        override fun areItemsTheSame(oldItem: SongTrackItem, newItem: SongTrackItem): Boolean {
           return oldItem.data?.id == newItem.data?.id
        }

        override fun areContentsTheSame(oldItem: SongTrackItem, newItem: SongTrackItem): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = ItemTrackBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TrackViewHolder(view, click, like)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}