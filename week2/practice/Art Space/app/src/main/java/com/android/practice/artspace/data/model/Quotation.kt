package com.android.practice.artspace.data.model

import androidx.annotation.DrawableRes

data class Quotation(
    @DrawableRes
    val personImageResource: Int,
    val personName: String,
    val wiseSaying: String,
)