package com.vall.covidinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vall.covidinfo.databinding.ActivityVaksinBinding

class VaksinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVaksinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaksinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnListvaksin.setOnClickListener {
            startActivity(Intent(this,ListVaksinActivity::class.java))
        }
    }
}