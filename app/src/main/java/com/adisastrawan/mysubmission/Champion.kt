package com.adisastrawan.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champion(
    val name:String,
    val description:String,
    val photo:Int,
    val difficulty:String = "Low",
    val role:String,
    val subname:String
):Parcelable
