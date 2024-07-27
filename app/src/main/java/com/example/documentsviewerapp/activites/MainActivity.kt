package com.example.documentsviewerapp.activites

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.documentsviewerapp.R
import com.example.documentsviewerapp.fragments.MainPageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setFragments()
    }
    private fun setFragments() {
        val fragment = MainPageFragment()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.mainFrameLayout, fragment)
            .addToBackStack("mainFragment")
            .commit()
    }
}