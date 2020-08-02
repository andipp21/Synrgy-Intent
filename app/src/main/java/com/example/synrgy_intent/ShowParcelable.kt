package com.example.synrgy_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_parcelable.*
import kotlinx.android.synthetic.main.activity_show_serializable.*

class ShowParcelable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_parcelable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val person = intent.getParcelableExtra("objPerson") as PersonParcelable

        tvShowNamaParcel.setText(person.nama)
        tvShowUmurParcel.setText(person.umur.toString())
    }
}