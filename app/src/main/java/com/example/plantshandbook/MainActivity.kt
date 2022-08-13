package com.example.plantshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf<Int>(
        R.drawable.chamomile,
        R.drawable.cherry,
        R.drawable.beautiful_flower,
        R.drawable.pink_flower,
        R.drawable.rose,
        R.drawable.poppy,
        R.drawable.poppy2,
        R.drawable.raflezia,
        R.drawable.red_flower1,
        R.drawable.sunflower,
        R.drawable.tulip,
        R.drawable.viola,
        R.drawable.violet_flower,
        R.drawable.water_lily,
    )
    private var plantIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {
        // LinearLayoutManager(this),
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter

        btnAddPlant.setOnClickListener {
            if (plantIndex >= imageIdList.size) plantIndex = 0

            val plant = Plant(imageIdList[plantIndex], "flower ${plantIndex + 1 }")
            adapter.addPlant(plant)
            plantIndex++
        }
    }
}