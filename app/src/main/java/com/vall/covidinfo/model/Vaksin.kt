package com.vall.covidinfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Vaksin(
    var nama : String = "",
    var img : Int = 0,
    var asal : String = "",
    var bahan : String = "",
    var ujiklinis : String = ""
) : Parcelable
