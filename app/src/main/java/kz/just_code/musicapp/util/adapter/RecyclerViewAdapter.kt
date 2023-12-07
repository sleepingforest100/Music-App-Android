package kz.just_code.musicapp.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.musicapp.BaseViewHolder
import kz.just_code.musicapp.ButtonViewHolder
import kz.just_code.musicapp.HeaderViewHolder
import kz.just_code.musicapp.util.RecyclerViewItem
import kz.just_code.musicapp.data.model.Artist
import kz.just_code.musicapp.data.model.ItemType
import kz.just_code.musicapp.databinding.AddArtistBinding
import kz.just_code.musicapp.databinding.ItemArtistBinding

class RecyclerViewAdapter(
    private val items: List<RecyclerViewItem>,
    private val onButtonClickListener: (Artist) -> Unit
) : ListAdapter<Artist, BaseViewHolder<*, Artist>>(ArtistDiffUtils()) {

    class ArtistDiffUtils: DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(
            oldItem: Artist,
            newItem: Artist
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Artist,
            newItem: Artist
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, Artist> {
        return when (viewType) {
            ItemType.HEADER.ordinal -> {
                ButtonViewHolder(
                    AddArtistBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false), onButtonClickListener
                )
            }
            ItemType.ITEM.ordinal -> {
                HeaderViewHolder(
                    ItemArtistBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                HeaderViewHolder(
                    ItemArtistBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }



    override fun onBindViewHolder(holder: BaseViewHolder<*, Artist>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType?.ordinal ?: 0
    }
}
