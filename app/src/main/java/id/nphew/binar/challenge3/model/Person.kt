package id.nphew.binar.challenge3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val age: Int,
    val address: String,
    val job: String
): Parcelable
