package com.example.documentsviewerapp.fragments

import android.os.Bundle
import android.app.Fragment
import android.content.pm.PackageManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.example.documentsviewerapp.R
class MainPageFragment : Fragment() {

    val permissions = arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    private lateinit var showBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        initView(view)
        setClickListeners()

        return view
    }

    private fun askPermissions() {
        if (ActivityCompat.checkSelfPermission(context,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(
                activity,
                permissions,
                PackageManager.PERMISSION_GRANTED
            )
        } else {
            Log.e("DB", "PERMISSION GRANTED");
        }
    }

    private fun setClickListeners() {
        showBtn.setOnClickListener {
            askPermissions()
        }
    }

    private fun initView(view: View) {
        showBtn = view.findViewById(R.id.showBtn)
    }
}