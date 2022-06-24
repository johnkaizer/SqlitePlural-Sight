package com.example.sqlite_pluralsight

import com.example.sqlite_pluralsight.DogsDbContract.CarEntry

object DataManager {
    fun fetchAllCars(databaseHelper: DatabaseHelper) : ArrayList<Car>{
        val cars =ArrayList<Car>()
        val db=databaseHelper.readableDatabase

        val columns = arrayOf(
            CarEntry.COLUMN_ID,
            CarEntry.COLUMN_NAME,
            CarEntry.COLUMN_DOM,
            CarEntry.COLUMN_MANUFACTURE
        )
       val cursor = db.query(CarEntry.TABLE_NAME,
        columns,
        null,
        null,
        null,
        null,
        null)

        val idPos=cursor.getColumnIndex(CarEntry.COLUMN_ID)
        val namePos=cursor.getColumnIndex(CarEntry.COLUMN_NAME)
        val domPos=cursor.getColumnIndex(CarEntry.COLUMN_DOM)
        val manufacturePos=cursor.getColumnIndex(CarEntry.COLUMN_MANUFACTURE)

        while (cursor.moveToNext()){
            val id= cursor.getString(idPos)
            val name= cursor.getString(namePos)
            val dom= cursor.getLong(domPos)
            val manufacture= cursor.getString(manufacturePos)
            cars.add(Car(id,name,dom, manufacture))
        }
        cursor.close()
        return  cars
    }
}