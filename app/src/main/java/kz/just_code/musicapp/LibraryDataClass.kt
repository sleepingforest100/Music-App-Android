package kz.just_code.musicapp

data class AddArtist(val name: String, val type: ItemType)
data class HeaderItem(val title: String) : RecyclerViewItem(0, ItemType.HEADER) {
    override val itemType: ItemType
        get() = ItemType.HEADER
}

data class ButtonItem(val addArtist: AddArtist) : RecyclerViewItem() {
    override val itemType: ItemType
        get() = ItemType.ITEM
}



enum class ItemType {
    HEADER,
    ITEM
}
