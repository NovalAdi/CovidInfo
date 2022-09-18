package com.vall.covidinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.covidinfo.adapter.CountryAdapter
import com.vall.covidinfo.databinding.ActivityMainBinding
import com.vall.covidinfo.model.CountriesItem
import com.vall.covidinfo.model.ResponseCovid
import com.vall.covidinfo.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapters: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        binding.btnAboutcovid.setOnClickListener {
            startActivity(Intent(this,AboutCovidActivity::class.java))
        }
        binding.btnPencegahancovid.setOnClickListener {
            startActivity(Intent(this,VaksinActivity::class.java))
        }

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapters.filter.filter(newText)
                return false
            }

        })

        binding.swipeView.setOnRefreshListener {
            getCountry()
            binding.swipeView.isRefreshing = false
        }

        getCountry()

    }

    private fun intenttoDetail(country : CountriesItem) {
        val pergi = Intent(this,DetailActivity::class.java)
        pergi.putExtra(DetailActivity.EXTRA_COUNTRY, country)
        startActivity(pergi)
    }

    private fun getCountry() {
        val call = APIService.getServiceCovid().getAllNegara()

        call.enqueue(object : Callback<ResponseCovid> {
            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                if (response.isSuccessful) {
                    val listNegara = response.body()?.global
                    val formatter: NumberFormat = DecimalFormat("#,###")
                    binding.txtPositifGlobal.text = formatter.format(listNegara!!.totalConfirmed)
                    binding.txtMeniggalGlobal.text = formatter.format(listNegara.totalDeaths)
                    binding.txtSembuhGlobal.text = formatter.format(listNegara.totalRecovered)
                    binding.recyclerCountry.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapters =
                            CountryAdapter(response.body()?.countries as ArrayList<CountriesItem>)
                            { country -> intenttoDetail(country) }
                        adapter = adapters
                        binding.progressBar.visibility = View.GONE
                    }
                } else {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                binding.progressBar.visibility = View.VISIBLE
                Timber.e(t.localizedMessage)

            }
        })
    }
}