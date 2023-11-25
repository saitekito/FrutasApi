package com.example.parcial2prueba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class DetailFruit(
    val name: String?,
    val id: Long,
    val nutritions: Nutritions
) : Parcelable

@Parcelize
data class Nutritions (
    val calories: Long,
    val fat: Double,
    val sugar: Double,
    val carbohydrates: Double,
    val protein: Double
) : Parcelable
