package com.example.synrgy_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.synrgy_intent.databinding.ActivityShowBundleBinding
import kotlinx.android.synthetic.main.activity_show_bundle.*

class ShowBundle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_bundle)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val umur = bundle?.getString("umur")

        tvShowNamaBundle.setText(nama)
        tvShowUmurBundle.setText(umur)

    }
}