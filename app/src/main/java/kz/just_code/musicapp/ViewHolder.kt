package kz.just_code.musicapp

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.musicapp.data.model.Artist
import kz.just_code.musicapp.databinding.AddArtistBinding
import kz.just_code.musicapp.databinding.ItemArtistBinding

class HeaderViewHolder(override val binding: ItemArtistBinding) :
    BaseViewHolder<ItemArtistBinding, Artist>(binding) {

    override fun bind(item: Artist) {
        binding.artistName.text = item.items?.firstOrNull()?.profile?.name
    }
}

class ButtonViewHolder(
    override val binding: AddArtistBinding,
    private val onButtonClickListener: (Artist) -> Unit
) :
    BaseViewHolder<AddArtistBinding, Artist>(binding) {

    override fun bind(item: Artist) {
        itemView.setOnClickListener { onButtonClickListener.invoke(item) }
    }
}

abstract class BaseViewHolder<VB : ViewBinding, T>(open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}

