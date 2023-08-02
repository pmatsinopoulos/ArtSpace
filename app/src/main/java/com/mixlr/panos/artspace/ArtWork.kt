package com.mixlr.panos.artspace

import androidx.annotation.DrawableRes

data class ArtWork(
    @DrawableRes val imageId: Int,
    val title: String,
    val subTitle: String,
    val publicationYear: String
)
