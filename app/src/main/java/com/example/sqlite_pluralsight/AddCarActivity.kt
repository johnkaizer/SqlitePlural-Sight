package com.example.sqlite_pluralsight

import android.app.Activity
import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_car.*
import java.text.SimpleDateFormat
import java.util.*

class AddCarActivity : Activity() {
    private val myCalendar = Calendar.getInstance()
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        databaseHelper = DatabaseHelper(this)

        // on clicking ok on the calender dialog
        val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            etDOM.setText(getFormattedDate(myCalendar.timeInMillis))
        }

        etDOM.setOnClickListener {
            setUpCalender(date)
        }
        bSave.setOnClickListener {
            saveCar()

        }
        bCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveCar() {
        var isValid = true
        etCarName.error = if (etCarName?.text.toString().isEmpty()){
            isValid = false
            "Required field"
        }else null
        etManufacture.error = if (etManufacture?.text.toString().isEmpty()){
            isValid = false
            "Required field"
        }else null
        if (isValid){
            val name:String =etCarName?.text.toString()
            val dom:Long = myCalendar.timeInMillis
            val manufacture: String=etManufacture?.text.toString()

            val db = databaseHelper.writableDatabase
            val values = ContentValues()
            values.put(DogsDbContract.CarEntry.COLUMN_NAME,name)
            values.put(DogsDbContract.CarEntry.COLUMN_MANUFACTURE,manufacture)
            values.put(DogsDbContract.CarEntry.COLUMN_DOM, dom)

            val result =db.insert(DogsDbContract.CarEntry.TABLE_NAME, null, values)

            setResult(RESULT_OK, Intent())
            Toast.makeText(applicationContext," Car successfully Added",Toast.LENGTH_SHORT).show()
        }
        finish()
    }

    private fun setUpCalender(date: DatePickerDialog.OnDateSetListener) {

        DatePickerDialog(
            this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun getFormattedDate(dobInMilis: Long?): String {

        return dobInMilis?.let {
            val sdf = SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
            sdf.format(dobInMilis)
        } ?: "Not Found"
    }
}