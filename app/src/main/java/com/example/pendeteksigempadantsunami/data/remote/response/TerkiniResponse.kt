package com.example.pendeteksigempadantsunami.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TerkiniResponse(

	@field:SerializedName("Infogempa")
	val infogempa: Infogempa
) : Parcelable

@Parcelize
data class Infogempa(

	@field:SerializedName("gempa")
	val gempa: Gempa
) : Parcelable

@Parcelize
data class Gempa(

	@field:SerializedName("Dirasakan")
	val dirasakan: String,

	@field:SerializedName("Wilayah")
	val wilayah: String,

	@field:SerializedName("Shakemap")
	val shakemap: String,

	@field:SerializedName("Kedalaman")
	val kedalaman: String,

	@field:SerializedName("Jam")
	val jam: String,

	@field:SerializedName("Coordinates")
	val coordinates: String,

	@field:SerializedName("Potensi")
	val potensi: String,

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
