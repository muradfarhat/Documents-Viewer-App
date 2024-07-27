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
import androidx.recyclerview.widget.RecyclerView
import com.example.documentsviewerapp.R
import com.example.documentsviewerapp.util.Util

class MainPageFragment : Fragment() {

    private lateinit var showBtn: Button
    private lateinit var fileRecyclerView: RecyclerView
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
                Util.permissions,
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
        fileRecyclerView = view.findViewById(R.id.filesRecyclerView)
    }
}