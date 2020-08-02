package com.example.synrgy_intent

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_whatsapp.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WhatsappFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WhatsappFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whatsapp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnWA.setOnClickListener {
            val phoneNumber = etNoTelpWA.text.toString()
            val messageContent = etPesanWA.text.toString()

            Log.d("Telepon ","${phoneNumber}, ${messageContent}")
            if (messageContent.isEmpty() && phoneNumber.isEmpty()) {
                Toast.makeText(context, "Masukan nomor telepon dan pesan whatsapp anda", Toast.LENGTH_SHORT).show()
            } else {

                val whatsappIsInstalled = waInstalledOrNot("com.whatsapp")
                Log.d("Telepon ",whatsappIsInstalled.toString())
                if (whatsappIsInstalled) {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(
                            "https://api.whatsapp.com/send?phone=+62${phoneNumber}&text=${messageContent}"
                        )
                    }

                    startActivity(intent)

                    etNoTelpWA.setText("")
                    etPesanWA.setText("")
                } else {
                    Toast.makeText(context,"App Whatsapp tidak terinstall", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun waInstalledOrNot(uri: String) : Boolean {
        val pm = context!!.packageManager
        val installed = try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }

        return installed
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WhatsappFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhatsappFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}