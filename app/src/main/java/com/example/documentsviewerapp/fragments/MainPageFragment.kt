package com.example.documentsviewerapp.fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.documentsviewerapp.R
class MainPageFragment : Fragment() {

    private lateinit var showBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {
        showBtn = view.findViewById(R.id.showBtn)
    }
}