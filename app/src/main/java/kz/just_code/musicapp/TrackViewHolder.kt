package kz.just_code.musicapp

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.just_code.musicapp.databinding.ItemTrackBinding

class TrackViewHolder(private val binding: ItemTrackBinding, private var click: ((SongTrackItem) -> Unit)?, private var like: ((SongTrackItem) -> Unit)?) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SongTrackItem) {
        // Set album name
        binding.trackTitle.text = item.data?.name
        binding.singerName.text = item.data?.artists?.items?.firstOrNull()?.profile?.name

        // Load album icon using Glide (or your preferred image loading library)
        Glide.with(itemView.context)
            .load(item.data?.albumOfTrack?.coverArt?.sources?.firstOrNull()?.url)
            .into(binding.trackIcon)

        binding.likeBtn.setOnClickListener {
            like?.invoke(item)
        }

        itemView.setOnClickListener {
            click?.invoke(item)
        }
    }
}