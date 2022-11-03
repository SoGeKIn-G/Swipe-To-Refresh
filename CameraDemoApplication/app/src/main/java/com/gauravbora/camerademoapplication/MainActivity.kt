package com.gauravbora.camerademoapplication

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var button: Button
    private lateinit var imageUri: Uri

    //    built in contract
    private val contract = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        image.setImageURI(null)
        image.setImageURI(imageUri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.image)
        button = findViewById(R.id.capture)
        imageUri = createImageUri()!!
        button.setOnClickListener {
            contract.launch(imageUri)
        }

    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "Camera_Photo.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.gauravbora.camerademoapplication.fileProvider",
            image
        )

    }

}