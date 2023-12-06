package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.just_code.musicapp.data.db.TrackEntity
import kz.just_code.musicapp.databinding.ItemPlaylistBinding

class TracksAdapter : ListAdapter<TrackEntity, TracksAdapter.TracksViewHolder>(TracksDiffUtils()) {
    class TracksDiffUtils : DiffUtil.ItemCallback<TrackEntity>() {
        override fun areItemsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TracksViewHolder {
        return TracksViewHolder(
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TracksViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrackEntity) {
            binding.playlistTitle.text = item.trackName
             Glide.with(itemView.context)
                 .load(item.imageUrl)
                 .into(binding.playlistIcon)
        }
    }
}