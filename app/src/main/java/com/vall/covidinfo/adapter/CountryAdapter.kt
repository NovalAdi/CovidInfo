package com.vall.covidinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.vall.covidinfo.databinding.ItemCountryBinding
import com.vall.covidinfo.model.CountriesItem
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class CountryAdapter(
    private val country: ArrayList<CountriesItem>,
    private val clickListener: (CountriesItem) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>(), Filterable {

    var countryfirstlist = ArrayList<CountriesItem>()

    init {
        countryfirstlist = country
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = countryfirstlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countryfirstlist[position], clickListener)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                countryfirstlist = if (charSearch.isEmpty()) {
                    country
                } else {
                    val resultList = ArrayList<CountriesItem>()
                    for (row in country) {
                        val search = row.country?.toLowerCase(Locale.ROOT) ?: ""
                        if (search.contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResult = FilterResults()
                filterResult.values = countryfirstlist
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryfirstlist = results?.values as ArrayList<CountriesItem>
                notifyDataSetChanged()
            }
        }
    }
}

class ViewHolder(var binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(negara: CountriesItem, clickListener: (CountriesItem) -> Unit) {

        val formatter: NumberFormat = DecimalFormat("#,###")

        binding.txtCountry.text = negara.country
        binding.txtPositif.text = formatter.format(negara.totalConfirmed)
        binding.txtSembuh.text = formatter.format(negara.totalRecovered)
        binding.txtMeniggal.text = formatter.format(negara.totalDeaths)

        itemView.setOnClickListener { clickListener(negara) }
//        binding.txtCountry.setOnClickListener { clickListener(negara) }
//        binding.txtPositif.setOnClickListener { clickListener(negara) }
//        binding.txtSembuh.setOnClickListener { clickListener(negara) }
//        binding.txtMeniggal.setOnClickListener { clickListener(negara) }
//        binding.card.setOnClickListener { clickListener(negara) }

    }
}