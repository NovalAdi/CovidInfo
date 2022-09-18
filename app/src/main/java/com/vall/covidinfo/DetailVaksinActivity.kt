package com.vall.covidinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vall.covidinfo.databinding.ActivityDetailVaksinBinding
import com.vall.covidinfo.model.Vaksin

class DetailVaksinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailVaksinBinding
    companion object{
        const val EXTRA_VAKSIN = "N"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailVaksinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Vaksin>(EXTRA_VAKSIN)

        binding.txtNama.text = data?.nama
        binding.txtAsal.text = data?.asal
        binding.txtBahan.text = data?.bahan
        binding.txtUji.text = data?.ujiklinis
        binding.imgVaksinDetail.setImageResource(data!!.img)
    }
}