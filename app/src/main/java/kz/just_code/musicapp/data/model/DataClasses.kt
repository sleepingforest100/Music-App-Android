package kz.just_code.musicapp.data.model

import kz.just_code.musicapp.util.adapter.PlaylistSecondList
import kz.just_code.musicapp.data.db.TrackEntity

//ALL DATA CLASSES
data class SearchResponse(
    val albums: Albums? = null,
    val artists: Artists? = null,
    val genres: Genres? = null,
    val playlists: Playlists? = null,
    val podcasts: Podcasts? = null,
    val tracks: Tracks? = null,
    val topResults: TopResults? = null
)

//ALBUMS
data class Albums(
    val totalCount: Int? = null,
    val items: List<AlbumItem>? = null
)

data class AlbumItem(
    val data: AlbumData? = null
)

data class AlbumData(
    val uri: String? = null,
    val name: String? = null,
    val artists: Artist? = null,
    val coverArt: CoverArt? = null,
    val date: AlbumDate? = null
)

data class Artist(
    val id: Int? = null,
    val items: List<ArtistItem>? = null,
    val viewType: ItemType? = ItemType.ITEM
)

data class ArtistItem(
    val uri: String? = null,
    val profile: ArtistProfile? = null
)

data class ArtistProfile(
    val name: String? = null
)

data class CoverArt(
    val sources: List<CoverArtSource>? = null
)

data class CoverArtSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class AlbumDate(
    val year: Int? = null
)

//ARTISTS
data class Artists(
    val totalCount: Int? = null,
    val items: List<ArtistItemData>? = null
)

data class ArtistItemData(
    val data: ArtistDataInfo? = null
)

data class ArtistDataInfo(
    val uri: String? = null,
    val profile: ArtistProfileInfo? = null,
    val visuals: ArtistVisualsInfo? = null
)

data class ArtistProfileInfo(
    val name: String? = null
)

data class ArtistVisualsInfo(
    val avatarImage: AvatarImageInfo? = null
)

data class AvatarImageInfo(
    val sources: List<AvatarImageSourceInfo>? = null
)

data class AvatarImageSourceInfo(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

//GENRES
//data class Genres(
//    val totalCount: Int? = null,
//    val items: List<GenreItem>? = null
//)
//
//data class GenreItem(
//    val data: GenreData? = null
//)
//
//data class GenreData(
//    val placeholder: String? = null
//)
data class Genres(
    val items: List<GenresItem>
)

data class GenresItem(
    val content: GenresItemContent,
    val custom_fields: List<Any>,
    val external_urls: Any?,
    val id: String,
    val images: List<GenresImage>,
    val name: String,
    val rendering: String,
    val tag_line: Any?,
    val type: String
)

data class GenresItemContent(
    val items: List<Any>,
    val limit: Int,
    val next: Any?,
    val offset: Int,
    val previous: Any?,
    val total: Int
)

data class GenresImage(
    val height: Int?,
    val name: String,
    val url: String,
    val width: Int?
)


//PLAYLISTS
data class Playlists(
    val totalCount: Int? = null,
    val items: List<PlaylistItem>? = null
)

data class PlaylistItem(
    val data: PlaylistData? = null
)

data class PlaylistData(
    val uri: String? = null,
    val name: String? = null,
    val description: String? = null,
    val images: PlaylistImages? = null,
    val owner: PlaylistOwner? = null
)

data class PlaylistImages(
    val items: List<PlaylistImageItem>? = null
)

data class PlaylistImageItem(
    val sources: List<PlaylistImageSource>? = null
)

data class PlaylistImageSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class PlaylistOwner(
    val name: String? = null
)

//PODCASTS
data class Podcasts(
    val totalCount: Int? = null,
    val items: List<PodcastItem>? = null
)

data class PodcastItem(
    val data: PodcastData? = null
)

data class PodcastData(
    val uri: String? = null,
    val name: String? = null,
    val coverArt: PodcastCoverArt? = null,
    val type: String? = null,
    val publisher: PodcastPublisher? = null,
    val mediaType: String? = null
)

data class PodcastCoverArt(
    val sources: List<PodcastCoverSource>? = null
)

data class PodcastCoverSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class PodcastPublisher(
    val name: String? = null
)

//TOP RESULTS
data class TopResults(
    val items: List<TopResultItem>? = null,
    val featured: List<FeaturedItem>? = null
)

data class TopResultItem(
    val data: TopResultData? = null
)

data class TopResultData(
    val uri: String? = null,
    val profile: Profile? = null,
    val visuals: Visuals? = null
)

data class Profile(
    val name: String? = null
)

data class Visuals(
    val avatarImage: AvatarImage? = null
)

data class AvatarImage(
    val sources: List<AvatarImageSource>? = null
)

data class AvatarImageSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class FeaturedItem(
    val data: FeaturedData? = null
)

data class FeaturedData(
    val uri: String? = null,
    val name: String? = null,
    val description: String? = null,
    val images: Images? = null,
    val owner: Owner? = null
)

data class Images(
    val items: List<ImageItem>? = null
)

data class ImageItem(
    val sources: List<ImageSource>? = null
)

data class ImageSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class Owner(
    val name: String? = null
)


//TRACKS
data class Tracks(
    val totalCount: Int? = null,
    val items: List<SongTrackItem>? = null
)

data class SongTrackItem(
    val data: SongTrackData? = null
)

data class SongTrackData(
    val uri: String? = null,
    val id: String? = null,
    val name: String? = null,
    val albumOfTrack: SongAlbumOfTrack? = null,
    val artists: SongArtists? = null,
    val contentRating: SongContentRating? = null,
    val duration: SongDuration? = null,
    val playability: SongPlayability? = null
) {
    fun getTrackEntity(): TrackEntity {
        return TrackEntity(
            id = 0,
            imageUrl = albumOfTrack?.coverArt?.sources?.firstOrNull()?.url.orEmpty(),
            trackName = name.orEmpty(),
            artistName = artists?.items?.firstOrNull()?.profile?.name.orEmpty(),
            albumName = albumOfTrack?.name.orEmpty(),
            durationMs = (duration?.totalMilliseconds ?: 0).toLong()
        )
    }
}

data class SongAlbumOfTrack(
    val uri: String? = null,
    val name: String? = null,
    val coverArt: SongCoverArt? = null,
    val id: String? = null,
    val sharingInfo: SongSharingInfo? = null
)

data class SongArtists(
    val items: List<SongArtistItem>? = null
)

data class SongArtistItem(
    val uri: String? = null,
    val profile: SongArtistProfile? = null
)

data class SongArtistProfile(
    val name: String? = null
)

data class SongCoverArt(
    val sources: List<SongCoverArtSource>? = null
)

data class SongCoverArtSource(
    val url: String? = null,
    val width: Int? = null,
    val height: Int? = null
)

data class SongContentRating(
    val label: String? = null
)

data class SongDuration(
    val totalMilliseconds: Int? = null
)

data class SongPlayability(
    val playable: Boolean? = null
)

data class SongSharingInfo(
    val shareUrl: String? = null
)

data class AlbumsResponse(
    val albums: List<AlbumsData>? = null
)

data class AlbumsData(
    val album_type: String? = null,
    val genres: List<String>? = null,
    val id: String? = null,
    val images: List<GenresImage>? = null,
    val is_playable: Boolean? = null,
    val label: String? = null,
    val name: String? = null,
    val popularity: Int? = null,
    val release_date: String? = null,
    val release_date_precision: String? = null,
    val total_tracks: Int? = null,
    val tracks: AlbumTracks? = null,
    val type: String? = null,
    val uri: String? = null
)
 {
    fun getPlaylist(id: Int): PlaylistSecondList {
        return PlaylistSecondList(
            id = id,
            title = name.orEmpty(),
            image = images?.firstOrNull()?.url.orEmpty(),
            description = label.orEmpty(),
            tracks = tracks?.items.orEmpty()
        )
    }
}

data class AlbumTracks(
    val items: List<Track>? = null,
    val limit: Int? = null,
    val offset: Int? = null,
    val total: Int? = null
)

data class Image(
    val height: Int? = null,
    val url: String? = null,
    val width: Int? = null
)

data class Track(
    val disc_number: Int? = null,
    val duration_ms: Long? = null,
    val explicit: Boolean? = null,
    val external_urls: ExternalUrls? = null,
    val id: String? = null,
    val is_local: Boolean? = null,
    val is_playable: Boolean? = null,
    val name: String? = null,
    val preview_url: String? = null,
    val track_number: Int? = null,
    val type: String? = null,
    val uri: String? = null
)

data class ExternalUrls(
    val spotify: String? = null
)

