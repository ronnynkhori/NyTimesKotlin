package com.example.nytimes.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    @SerializedName("media-metadata")
    val mediaMetaData: List<MediaMetadata>,
    val subtype: String,
    val type: String
)  {
    fun getMetaData(mediaSize: MediaSize = MediaSize.NORMAL): MediaMetadata? {
        return mediaMetaData.find {
            when (mediaSize) {
                MediaSize.THUMB -> it.format == "mediumThreeByTwo210"
                MediaSize.NORMAL -> it.format == "mediumThreeByTwo440"
            }
        }
    }

    enum class MediaSize {
        THUMB, NORMAL
    }
}
