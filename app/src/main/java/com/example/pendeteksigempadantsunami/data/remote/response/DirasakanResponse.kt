package com.example.pendeteksigempadantsunami.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DirasakanResponse(

	@field:SerializedName("Infogempa")
	val infogempa: InfogempaDirasakan
) : Parcelable

@Parcelize
data class InfogempaDirasakan(

	@field:SerializedName("gempa")
	val gempa: List<GempaItemDirakan>
) : Parcelable

@Parcelize
data class GempaItemDirakan(

	@field:SerializedName("Dirasakan")
	val dirasakan: String,

	@field:SerializedName("Wilayah")
	val wilayah: String,

	@field:SerializedName("Kedalaman")
	val kedalaman: String,

	@field:SerializedName("Jam")
	val jam: String,

	@field:SerializedName("Coordinates")
	val coordinates: String,

	@field:SerializedName("Tanggal")
	val tanggal: String,

	@field:SerializedName("Bujur")
	val bujur: String,

	@field:SerializedName("Magnitude")
	val magnitude: String,

	@field:SerializedName("Lintang")
	val lintang: String,

	@field:SerializedName("DateTime")
	val dateTime: String
) : Parcelable
