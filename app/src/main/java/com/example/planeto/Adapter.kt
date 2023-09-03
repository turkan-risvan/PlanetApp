package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.planeto.databinding.ItemViewBinding

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var title = binding.title
        var planetimg = binding.planetImg
        var galaxy = binding.galaxy
        var distance = binding.distance
        var gravity = binding.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetails::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text = planet[position].title
        holder.distance.text = planet[position].distance + " m km"
        holder.galaxy.text = planet[position].galaxy
        holder.gravity.text = planet[position].gravity + " m/ss"

        when (planet[position].title!!.toLowerCase()) {


            "mars" -> {
                dummyImage = R.drawable.mars
            }

            "neptune" -> {
                dummyImage = R.drawable.neptune
            }

            "earth" -> {
                dummyImage = R.drawable.earth
            }

            "moon" -> {
                dummyImage = R.drawable.moon
            }

            "venus" -> {
                dummyImage = R.drawable.venus
            }

            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }

            "saturn" -> {
                dummyImage = R.drawable.saturn
            }

            "uranus" -> {
                dummyImage = R.drawable.uranus
            }

            "mercury" -> {
                dummyImage = R.drawable.mercury
            }

            "sun" -> {
                dummyImage = R.drawable.sun
            }


        }
        holder.planetimg.setImageResource(dummyImage!!)
    }
}

