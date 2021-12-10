package com.zaelani.pendeteksigempadantsunami.data.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TerkiniEntity(

    val dirasakan: String,

    val wilayah: String,

    val shakemap: String,

    val kedalaman: String,

    val jam: String,

    val coordinates: String,

    val potensi: String,

    val tanggal: String,

    val bujur: String,

    val magnitude: String,

    val lintang: String,

    val dateTime: String
) : Parcelable
