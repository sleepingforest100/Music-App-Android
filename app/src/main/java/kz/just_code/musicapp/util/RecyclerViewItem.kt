package kz.just_code.musicapp.util

import kz.just_code.musicapp.data.model.ItemType

open class RecyclerViewItem(
    var id: Int = 0,
    var itemType: ItemType = ItemType.ITEM
)