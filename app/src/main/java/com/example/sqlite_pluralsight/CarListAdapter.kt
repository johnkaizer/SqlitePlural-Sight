package com.example.sqlite_pluralsight

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class CarListAdapter(private val context: Context) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {
    lateinit var carList:ArrayList<Car>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return CarViewHolder(itemView)
    }

    override fun getItemCount(): Int =carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car =carList[position]
        holder.setData(car.name,car.manufacture)
    }

    fun setCars(cars: ArrayList<Car>) {
        carList =cars
        notifyDataSetChanged()
    }

    class CarViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {
        fun setData(name: String, manufacture: String) {
            itemView.tvCarName.text=name
            itemView.tvManufacture.text =manufacture
        }
    }
}
