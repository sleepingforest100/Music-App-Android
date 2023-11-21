package kz.just_code.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
