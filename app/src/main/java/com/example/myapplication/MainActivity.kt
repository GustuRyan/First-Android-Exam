package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvHero: RecyclerView
    private val list = ArrayList<Furnitures>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setTitle(R.string.my_navbar_title)

        rvHero = findViewById(R.id.rv_hero)
        rvHero.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

        val iconUser = findViewById<ImageView>(R.id.icon_user)
        iconUser.setOnClickListener {
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Furnitures> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataCategory = resources.getStringArray(R.array.data_category)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFurnitures = ArrayList<Furnitures>()
        for (i in dataName.indices) {
            val furnitures = Furnitures(dataName[i], dataDescription[i], dataCategory[i], dataPrice[i], dataPhoto.getResourceId(i, -1))
            listFurnitures.add(furnitures)
        }
        return listFurnitures
    }

    private fun showRecyclerList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listFurnitureAdapter = ListFurnitureAdapter(list)
        rvHero.adapter = listFurnitureAdapter
    }
}
