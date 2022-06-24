package com.example.sqlite_pluralsight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var databaseHelper: DatabaseHelper
    private val CarListAdapter = CarListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)
        recyclerView.adapter = CarListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        CarListAdapter.setCars(DataManager.fetchAllCars(databaseHelper))

        fab.setOnClickListener {
            val addCar = Intent(this, AddCarActivity::class.java)
            startActivityForResult(addCar, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}