package com.example.plantshandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.plantshandbook.databinding.ActivityEdiltBinding

class EdiltActivity : AppCompatActivity() {
    lateinit var binding: ActivityEdiltBinding
    private var indexImage = 0
    private val imageIdList = listOf(
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
    private var imageId = imageIdList[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEdiltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageResource(imageId)

        initButtons()
    }

    private fun initButtons() = with(binding) {
        btnNextImg.setOnClickListener {
            indexImage++

            if (indexImage >= imageIdList.size) indexImage = 0

            Log.d("MyLog", indexImage.toString())

            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)

        }

        btnDone.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()

            val plant = Plant(imageId,title, description)
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }

            setResult(RESULT_OK, editIntent)
            finish()


        }
    }

}