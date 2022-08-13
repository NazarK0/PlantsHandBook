package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private lateinit var editLauncher :ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        val contract = ActivityResultContracts.StartActivityForResult()
        editLauncher = registerForActivityResult(contract) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() = with(binding) {
        // LinearLayoutManager(this),
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = adapter

        btnAddPlant.setOnClickListener {
            editLauncher.launch(Intent(this@MainActivity, EdiltActivity::class.java))
        }
    }
}