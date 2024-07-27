package com.example.documentsviewerapp.util

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.util.Log
import androidx.core.app.ActivityCompat
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import java.io.File

object Util {
    val permissions = arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    fun loadDocx(filePath: String): WordprocessingMLPackage {
        val file = File(filePath)
        if(!file.exists()) {
            Log.e("File == ", "No File in this path")
        }
        return WordprocessingMLPackage.load(file)
    }

    fun renderDocxToImages(docxPackage: WordprocessingMLPackage): List<Bitmap> {
        val images = mutableListOf<Bitmap>()

        // Pseudo-code for rendering each page
        docxPackage.mainDocumentPart.content.forEach { element ->
            val pageImage = convertElementToImage(element)
            images.add(pageImage)
        }

        return images
    }

    fun convertElementToImage(element: Any): Bitmap {
        // Implement the rendering logic here
        // This is a placeholder for converting document elements to Bitmap
        return Bitmap.createBitmap(800, 600, Bitmap.Config.ARGB_8888)
    }

}