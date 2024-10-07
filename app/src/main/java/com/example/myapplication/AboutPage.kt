package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity() {

    private lateinit var profilePicture: ImageView
    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)

        // Inisialisasi views
        profilePicture = findViewById(R.id.profile_picture)
        tvUsername = findViewById(R.id.tv_username)
        tvEmail = findViewById(R.id.tv_email)

        // Mengambil data pengguna (ini hanya contoh)
        val username = "Ida Bagus Putu Ryan Paramasatya Putra" // Ganti dengan data asli
        val email = "rian.putra2003@gmail.com" // Ganti dengan data asli

        // Menampilkan data di TextView
        tvUsername.text = username
        tvEmail.text = email

        // Mengatur foto profil (misalnya, menggunakan gambar placeholder)
        // Anda bisa mengganti ini dengan gambar nyata jika diperlukan
        profilePicture.setImageResource(R.drawable.profile_picture)

        val iconBack = findViewById<ImageView>(R.id.icon_back)
        iconBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
