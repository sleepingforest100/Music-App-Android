package kz.just_code.musicapp

data class AddArtist(val name: String) : RecyclerViewItem(itemType = ItemType.ADD)
data class HeaderItem(val title: String) : RecyclerViewItem(itemType = ItemType.HEADER)

data class ButtonItem(val addArtist: AddArtist) : RecyclerViewItem(itemType = ItemType.ITEM)

enum class ItemType {
    HEADER,
    ITEM,
    ADD
}
