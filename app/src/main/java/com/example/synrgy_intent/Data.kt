package com.example.synrgy_intent

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class PersonSerialization(val nama:String, val umur:Int): Serializable

data class PersonParcelable(val nama: String?, val umur: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(umur)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonParcelable> {
        override fun createFromParcel(parcel: Parcel): PersonParcelable {
            return PersonParcelable(parcel)
        }

        override fun newArray(size: Int): Array<PersonParcelable?> {
            return arrayOfNulls(size)
        }
    }
}