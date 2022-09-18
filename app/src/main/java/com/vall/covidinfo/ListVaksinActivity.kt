package com.vall.covidinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.covidinfo.adapter.VaksinAdapter
import com.vall.covidinfo.data.VaksinData
import com.vall.covidinfo.databinding.ActivityListVaksinBinding
import com.vall.covidinfo.model.Vaksin

class ListVaksinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListVaksinBinding
    private val list : ArrayList<Vaksin> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListVaksinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerVaksin.setHasFixedSize(true)
            recyclerVaksin.adapter = VaksinAdapter(list)
            recyclerVaksin.layoutManager = LinearLayoutManager(baseContext)
            list.addAll(VaksinData.listVaksin)
        }
    }
}