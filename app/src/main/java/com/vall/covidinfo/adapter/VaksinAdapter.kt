package com.vall.covidinfo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vall.covidinfo.DetailVaksinActivity
import com.vall.covidinfo.databinding.ItemRecyclerVaksinBinding
import com.vall.covidinfo.model.Vaksin

class VaksinAdapter(val list: ArrayList<Vaksin> = arrayListOf()): RecyclerView.Adapter<VaksinAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerVaksinBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerVaksinBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vaksin = list[position]

        holder.binding.txtNamavaksin.text = vaksin.nama
        holder.binding.imgVaksin.setImageResource(vaksin.img)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context,DetailVaksinActivity::class.java)
            pergi.putExtra(DetailVaksinActivity.EXTRA_VAKSIN,vaksin)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}