package com.example.homework11.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class ImageModel(
    val name: String,
    val image: Int,
    val description: String,
    val id: UUID = UUID.randomUUID()
) : Parcelable
