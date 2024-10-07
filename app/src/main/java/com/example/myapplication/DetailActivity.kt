package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Furnitures
import com.example.myapplication.R

class DetailActivity : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvCategory: TextView
    private lateinit var tvPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        imgPhoto = findViewById(R.id.img_detail_photo)
        tvName = findViewById(R.id.tv_detail_name)
        tvDescription = findViewById(R.id.tv_detail_description)
        tvCategory = findViewById(R.id.tv_detail_category)
        tvPrice = findViewById(R.id.tv_detail_price)

        val iconBack = findViewById<ImageView>(R.id.icon_back)
        iconBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Get data from Intent
        val furniture = intent.getParcelableExtra<Furnitures>("EXTRA_FURNITURE")

        // Set data to views
        furniture?.let {
            tvName.text = it.name
            tvDescription.text = it.description
            tvCategory.text = it.category
            tvPrice.text = it.price
            if (it.photo != null) {
                imgPhoto.setImageResource(it.photo)
            }
        }

        val btnShare = findViewById<Button>(R.id.action_share)
        btnShare.setOnClickListener {
            shareToInstagram(furniture)
        }
    }
    private fun shareToInstagram(furniture: Furnitures?) {
        furniture?.let {
            val shareText = "Check out this furniture!\nName: ${it.name}\nDescription: ${it.description}"
            val uri = Uri.parse("http://www.instagram.com")

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
                putExtra(Intent.EXTRA_STREAM, uri)
                setPackage("com.instagram.android")
            }

            try {
                startActivity(shareIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}