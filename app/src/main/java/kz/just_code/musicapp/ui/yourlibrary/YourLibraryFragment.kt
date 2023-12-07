package kz.just_code.musicapp.ui.yourlibrary

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.musicapp.data.model.AddArtist
import kz.just_code.musicapp.data.model.Artist
import kz.just_code.musicapp.data.model.ArtistItem
import kz.just_code.musicapp.data.model.ArtistProfile
import kz.just_code.musicapp.data.model.HeaderItem
import kz.just_code.musicapp.data.model.ItemType
import kz.just_code.musicapp.util.adapter.RecyclerViewAdapter
import kz.just_code.musicapp.databinding.FragmentYourLibraryBinding
import kz.just_code.musicapp.ui.base.BaseFragment

class YourLibraryFragment :
    BaseFragment<FragmentYourLibraryBinding>(FragmentYourLibraryBinding::inflate) {
    private val onAddArtistClickListener: (AddArtist) -> Unit = { addArtist ->
        // Toast.makeText(ContentProviderCompat.requireContext(), "Button clicked for ${addArtist.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerviewLibrary

        binding.searchIcon.setOnClickListener {
            findNavController().navigate(YourLibraryFragmentDirections.actionYourLibraryFragmentToSearchFragment())
        }
        binding.userIcon.setOnClickListener {
            findNavController().navigate(YourLibraryFragmentDirections.actionYourLibraryFragmentToUserFragment())
        }

        val items = listOf(
            HeaderItem("Add tracks"),
            // ButtonItem(AddArtist("Artist 1", ItemType.ITEM)),
            // ButtonItem(AddArtist("Artist 2", ItemType.ITEM)),

        )
        val adapter = RecyclerViewAdapter(items) { artist ->

            Toast.makeText(
                requireContext(),
                "Button clicked for ${artist.items}",
                Toast.LENGTH_SHORT
            ).show()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.submitList(
            listOf(
                Artist(
                    0,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(
                    1,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(
                    2,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(
                    3,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(
                    4,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(
                    5,
                    listOf(ArtistItem("", ArtistProfile(name = "Anton"))),
                    viewType = ItemType.ITEM
                ),
                Artist(4, null, ItemType.HEADER)
            )
        )

    }

}