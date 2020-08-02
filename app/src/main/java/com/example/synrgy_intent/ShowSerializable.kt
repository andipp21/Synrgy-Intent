package com.example.synrgy_intent

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_bundle.*
import kotlinx.android.synthetic.main.activity_show_serializable.*

class ShowSerializable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_serializable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val person = intent.getSerializableExtra("objPerson") as PersonSerialization
        tvShowNamaSerializable.setText(person.nama)
        tvShowUmurSerializable.setText(person.umur.toString())
    }
}