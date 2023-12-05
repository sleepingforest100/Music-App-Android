package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.musicapp.databinding.ItemTrackBinding

class TrackAdapter() :
    ListAdapter<SongTrackItem, TrackViewHolder>(AlbumDiffUtils()) {

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
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}